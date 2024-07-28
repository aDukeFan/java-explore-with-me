package ru.practicum.service;


import dto.EndpointHitDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.mapper.EndpointHitMapper;
import ru.practicum.repository.StatsRepository;

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
