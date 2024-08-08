package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.EventShortDto;
import ru.practicum.ewm.main.dto.NewEventDto;
import ru.practicum.ewm.main.dto.ParticipationRequestDto;
import ru.practicum.ewm.main.request.EventRequestStatusUpdateRequest;
import ru.practicum.ewm.main.request.EventRequestStatusUpdateResult;
import ru.practicum.ewm.main.request.UpdateEventUserRequest;
import ru.practicum.ewm.main.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/{userId}/events")
    @ResponseStatus(HttpStatus.CREATED)
    public EventFullDto saveEvent(@PathVariable Integer userId,
                                  @Valid @RequestBody NewEventDto newEventDto) {
        return service.saveEvent(userId, newEventDto);
    }

    @GetMapping("/{userId}/events")
    public List<EventShortDto> getEventsByUserId(@PathVariable Integer userId,
                                                 @RequestParam(defaultValue = "0", required = false) Integer from,
                                                 @RequestParam(defaultValue = "10", required = false) Integer size) {
        return service.getEventsByUserId(userId, from, size);
    }

    @GetMapping("/{userId}/events/{eventId}")
    public EventFullDto getEventByUserIdAndEventId(@PathVariable Integer userId,
                                                   @PathVariable Integer eventId) {
        return service.getEventByUserIdAndEventId(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}")
    public EventFullDto updateEventByUserIdAndEventId(@PathVariable Integer userId,
                                                      @PathVariable Integer eventId,
                                                      @Valid @RequestBody UpdateEventUserRequest request) {
        return service.updateEventByUserIdAndEventId(userId, eventId, request);
    }

    @GetMapping("/{userId}/events/{eventId}/requests")
    public List<ParticipationRequestDto> getEventRequests(@PathVariable Integer userId,
                                                          @PathVariable Integer eventId) {
        return service.getEventsRequests(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}/requests")
    public EventRequestStatusUpdateResult setRequestStatus(@PathVariable Integer userId,
                                                           @PathVariable Integer eventId,
                                                           @RequestBody EventRequestStatusUpdateRequest request) {
        return service.setRequestStatus(userId, eventId, request);
    }

    @GetMapping("/{userId}/requests")
    public List<ParticipationRequestDto> getAllUserRequests(@PathVariable Integer userId) {
        return service.getAllUserRequests(userId);
    }

    @PostMapping("/{userId}/requests")
    public ParticipationRequestDto sendNewRequest(@PathVariable Integer userId,
                                                  @RequestParam Integer eventId) {
        return service.saveNewRequest(userId, eventId);
    }


    @PatchMapping("/{userId}/requests/{requestId}/cancel")
    public ParticipationRequestDto cancelRequest(@PathVariable Integer userId,
                                                 @PathVariable Integer requestId) {
        return service.canselRequest(userId, requestId);
    }
}
