package ru.practicum.ewm.main.service;

import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.EventShortDto;
import ru.practicum.ewm.main.dto.NewEventDto;
import ru.practicum.ewm.main.dto.ParticipationRequestDto;
import ru.practicum.ewm.main.request.EventRequestStatusUpdateRequest;
import ru.practicum.ewm.main.request.EventRequestStatusUpdateResult;
import ru.practicum.ewm.main.request.UpdateEventUserRequest;

import java.util.List;

public interface UserService {

    EventFullDto saveEvent(Integer userId, NewEventDto newEventDto);

    List<EventShortDto> getEventsByUserId(Integer userId, Integer from, Integer size);

    EventFullDto getEventByUserIdAndEventId(Integer userId, Integer eventId);

    EventFullDto updateEventByUserIdAndEventId(Integer userId, Integer eventId, UpdateEventUserRequest request);

    List<ParticipationRequestDto> getEventsRequests(Integer userId, Integer eventId);

    EventRequestStatusUpdateResult setRequestStatus(Integer userId, Integer eventId, EventRequestStatusUpdateRequest request);

    List<ParticipationRequestDto> getAllUserRequests(Integer userId);

    ParticipationRequestDto saveNewRequest(Integer userId, Integer eventId);

    ParticipationRequestDto canselRequest(Integer userId, Integer requestId);
}
