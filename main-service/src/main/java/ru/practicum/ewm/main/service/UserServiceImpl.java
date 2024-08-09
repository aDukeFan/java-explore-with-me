package ru.practicum.ewm.main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.EventShortDto;
import ru.practicum.ewm.main.dto.NewEventDto;
import ru.practicum.ewm.main.dto.ParticipationRequestDto;
import ru.practicum.ewm.main.mapper.EventMapper;
import ru.practicum.ewm.main.mapper.LocationMapper;
import ru.practicum.ewm.main.mapper.ParticipationRequestMapper;
import ru.practicum.ewm.main.model.Category;
import ru.practicum.ewm.main.model.Event;
import ru.practicum.ewm.main.model.Location;
import ru.practicum.ewm.main.model.ParticipationRequest;
import ru.practicum.ewm.main.model.State;
import ru.practicum.ewm.main.model.User;
import ru.practicum.ewm.main.repository.CategoryRepository;
import ru.practicum.ewm.main.repository.EventRepository;
import ru.practicum.ewm.main.repository.LocationRepository;
import ru.practicum.ewm.main.repository.ParticipationRequestRepository;
import ru.practicum.ewm.main.repository.UserRepository;
import ru.practicum.ewm.main.request.EventRequestStatusUpdateRequest;
import ru.practicum.ewm.main.request.EventRequestStatusUpdateResult;
import ru.practicum.ewm.main.request.UpdateEventUserRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    private final ParticipationRequestRepository requestRepository;
    private final ParticipationRequestMapper requestMapper;


    @Override
    public EventFullDto saveEvent(Integer userId, NewEventDto newEventDto) {
        Location location = locationRepository.save(locationMapper.toSave(newEventDto.getLocation()));
        User user = userRepository.findById(userId).orElse(null);
        Category category = categoryRepository.findById(newEventDto.getCategory()).orElse(null);
        Event eventToSave = eventMapper.toSave(newEventDto);
        eventToSave.setState(State.PUBLISHED);
        eventToSave.setCreatedOn(LocalDateTime.now().withNano(0));
        eventToSave.setLocation(location);
        eventToSave.setUser(user);
        eventToSave.setCategory(category);
        return eventMapper.toShowFull(eventRepository.save(eventToSave));
    }

    @Override
    public List<EventShortDto> getEventsByUserId(Integer userId, Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from / size, size);
        return eventRepository.findAllByUserId(userId, pageable).stream()
                .map(eventMapper::toShowShort)
                .collect(Collectors.toList());
    }

    @Override
    public EventFullDto getEventByUserIdAndEventId(Integer userId, Integer eventId) {
        return eventMapper.toShowFull(eventRepository.findByIdAndUserId(eventId, userId));
    }

    @Override
    public EventFullDto updateEventByUserIdAndEventId(Integer userId, Integer eventId, UpdateEventUserRequest request) {
        return null;
    }

    @Override
    public List<ParticipationRequestDto> getEventsRequests(Integer userId, Integer eventId) {
        if(eventRepository.existsByIdAndUserId(eventId, userId)) {
            return requestRepository.findByEventId(eventId).stream()
                    .map(requestMapper::toShow)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    @Override
    public EventRequestStatusUpdateResult setRequestStatus(Integer userId, Integer eventId, EventRequestStatusUpdateRequest request) {
        return null;
    }

    @Override
    public List<ParticipationRequestDto> getAllUserRequests(Integer userId) {
        return requestRepository.findByRequesterId(userId).stream()
                .map(requestMapper::toShow)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipationRequestDto saveNewRequest(Integer userId, Integer eventId) {
        LocalDateTime created = LocalDateTime.now();
        ParticipationRequest participationRequest = new ParticipationRequest()
                .setCreated(created)
                .setRequester(userRepository.findById(userId).orElse(null))
                .setEvent(eventRepository.findById(eventId).orElse(null))
                .setStatus(State.PENDING);
        return requestMapper.toShow(requestRepository.save(participationRequest));
    }

    @Override
    public ParticipationRequestDto canselRequest(Integer userId, Integer requestId) {
        ParticipationRequest request = requestRepository.findByIdAndRequesterId(requestId, userId);
        request.setStatus(State.CANCELED);
        return requestMapper.toShow(requestRepository.save(request));
    }
}
