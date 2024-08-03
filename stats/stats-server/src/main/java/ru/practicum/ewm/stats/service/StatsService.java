package ru.practicum.ewm.stats.service;

import ru.practicum.ewm.dto.stats.EndpointHitDto;
import ru.practicum.ewm.dto.stats.ViewStatsDto;

import java.util.List;

public interface StatsService {

    void save(EndpointHitDto hitDto);

    List<ViewStatsDto> get(String app, String start, String end, List<String> uris, Boolean unique);

}
