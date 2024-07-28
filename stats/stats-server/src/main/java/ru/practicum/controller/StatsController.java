package ru.practicum.controller;

import dto.EndpointHitDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.model.EndpointHit;
import ru.practicum.service.StatsService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class StatsController {

    private final StatsService service;

    @PutMapping("/hit")
    public void save(@RequestBody EndpointHitDto hitDto) {
        service.save(hitDto);
    }

    @GetMapping("/stats")
    public List<EndpointHit> get(@RequestParam LocalDateTime start,
                                 @RequestParam LocalDateTime end,
                                 @RequestParam List<EndpointHitDto> uris,
                                 @RequestParam Boolean unique) {
        return null;
    }
}
