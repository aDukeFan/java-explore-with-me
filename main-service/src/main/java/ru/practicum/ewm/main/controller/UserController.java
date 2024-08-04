package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

//    @GetMapping("/{userId}/events")
//    @PostMapping("/{userId}/events")
//    @GetMapping("/{userId}/events/{eventId}")
//    @PatchMapping("/{userId}/events")
//    @GetMapping("/{userId}/events/")
}
