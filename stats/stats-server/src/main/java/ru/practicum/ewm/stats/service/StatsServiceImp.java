package ru.practicum.ewm.stats.service;


import ru.practicum.ewm.dto.stats.EndpointHitDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.stats.mapper.EndpointHitMapper;
import ru.practicum.ewm.stats.repository.StatsRepository;

@Slf4j
@Service
@AllArgsConstructor
public class StatsServiceImp implements StatsService {

    private final StatsRepository repository;
    private final EndpointHitMapper mapper;

    @Override
    public void save(EndpointHitDto hitDto) {
        repository.save(mapper.toSave(hitDto));
    }
}
