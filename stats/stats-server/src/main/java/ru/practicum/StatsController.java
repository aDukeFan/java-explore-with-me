package ru.practicum;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StatsController {

    private final StatsService service;

    @PutMapping("/hit")
    public Event save() {
        return null;
    }

    @GetMapping("/stats")
    public List<Event> get() {
        return null;
    }
}
