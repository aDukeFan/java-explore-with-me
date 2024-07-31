package ru.practicum.ewm.stats.service;


import ru.practicum.ewm.dto.stats.EndpointHitDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.dto.stats.ViewStatsDto;
import ru.practicum.ewm.stats.mapper.EndpointHitMapper;
import ru.practicum.ewm.stats.repository.StatsRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class StatsServiceImp implements StatsService {

    private final StatsRepository repository;
    private final EndpointHitMapper mapper;

    private static final String APP = "ewm-main-service";

    @Override
    public void save(EndpointHitDto hitDto) {
        repository.save(mapper.toSave(hitDto));
    }

    @Override
    public List<ViewStatsDto> get(String start, String end, List<String> uris, Boolean unique) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);
        List<ViewStatsDto> viewStatsList = new ArrayList<>();
        if (uris.isEmpty()) {
            uris.addAll(repository.findAllUriByTimestampBetween(startTime, endTime));
        }
        if (unique) {
            uris.forEach(uri -> viewStatsList.add(
                    new ViewStatsDto()
                            .setUri(uri)
                            .setApp(APP)
                            .setHits(repository.countUniqueIpByUriAndTimestampBetween(uri, startTime, endTime))));
        } else {
            uris.forEach(uri -> viewStatsList.add(
                    new ViewStatsDto()
                            .setApp(APP)
                            .setUri(uri)
                            .setHits(repository.countByUriAndTimestampBetween(uri, startTime, endTime))));
        }
        viewStatsList.sort(Comparator.comparing(ViewStatsDto::getHits).reversed());
        return viewStatsList;
    }
}
