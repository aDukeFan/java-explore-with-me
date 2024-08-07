package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.NewEventDto;
import ru.practicum.ewm.main.service.UserService;

import javax.validation.Valid;

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

//    @GetMapping("/{userId}/events")
//    public EventFullDto get(@PathVariable Integer userId) {
//        return service.getById(userId);
//    }


//    @GetMapping("/{userId}/events/{eventId}")
//    @PatchMapping("/{userId}/events")
//    @GetMapping("/{userId}/events/")
}
