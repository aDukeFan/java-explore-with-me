package ru.practicum.ewm.stats.service;

import ru.practicum.ewm.dto.stats.EndpointHitDto;
import ru.practicum.ewm.stats.model.ViewStats;

import java.util.List;

public interface StatsService {

    void save(EndpointHitDto hitDto);

    List<ViewStats> get(String start, String end, List<String> uris, Boolean unique);

}
