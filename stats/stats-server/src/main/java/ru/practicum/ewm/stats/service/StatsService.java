package ru.practicum.ewm.stats.service;

import ru.practicum.ewm.dto.stats.EndpointHitDto;

public interface StatsService {

    void save(EndpointHitDto hitDto);
}
