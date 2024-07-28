package ru.practicum.service;

import dto.EndpointHitDto;

public interface StatsService {

    void save(EndpointHitDto hitDto);
}
