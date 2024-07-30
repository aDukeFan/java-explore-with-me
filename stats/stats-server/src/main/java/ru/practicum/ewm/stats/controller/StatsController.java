package ru.practicum.ewm.stats.controller;

import ru.practicum.ewm.dto.stats.EndpointHitDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.stats.model.ViewStats;
import ru.practicum.ewm.stats.service.StatsService;

import java.util.List;

@RestController
@AllArgsConstructor
public class StatsController {

    private final StatsService service;

    @PostMapping("/hit")
    public void save(@RequestBody EndpointHitDto hitDto) {
        service.save(hitDto);
    }

    @GetMapping("/stats")
    public List<ViewStats> get(@RequestParam String start,
                               @RequestParam String end,
                               @RequestParam List<String> uris,
                               @RequestParam(required = false, defaultValue = "false") Boolean unique) {
        return service.get(start, end, uris, unique);
    }
}
