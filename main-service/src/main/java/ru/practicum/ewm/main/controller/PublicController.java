package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.service.PublicService;

@RestController
@RequestMapping
@AllArgsConstructor
public class PublicController {

    private final PublicService service;
}
