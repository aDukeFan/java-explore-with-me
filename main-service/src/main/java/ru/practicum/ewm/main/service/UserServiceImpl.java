package ru.practicum.ewm.main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.NewEventDto;
import ru.practicum.ewm.main.mapper.EventMapper;
import ru.practicum.ewm.main.mapper.LocationMapper;
import ru.practicum.ewm.main.model.Event;
import ru.practicum.ewm.main.model.Location;
import ru.practicum.ewm.main.model.State;
import ru.practicum.ewm.main.repository.EventRepository;
import ru.practicum.ewm.main.repository.LocationRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public EventFullDto saveEvent(Integer userId, NewEventDto newEventDto) {
        Location location = locationRepository.save(locationMapper.toSave(newEventDto.getLocation()));
        Integer locationId = location.getId();
        LocalDateTime createdOn = LocalDateTime.now();
        Event savedEvent = eventRepository.save(eventMapper.toSave(
                State.PUBLISHED,
                locationId,
                createdOn,
                userId,
                newEventDto));
        System.out.println(savedEvent.getUser().getName());
        return eventMapper.toShowWhileSave(savedEvent);
    }
}
