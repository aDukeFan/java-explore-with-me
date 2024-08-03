package ru.practicum.ewm.client.stats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.practicum.ewm.dto.stats.EndpointHitDto;
import ru.practicum.ewm.dto.stats.ViewStatsDto;

import java.util.List;
import java.util.Map;

public class StatsClient {

    public final RestTemplate template;

    public StatsClient(@Value("${stats-server.url}") String statsServerUrl, RestTemplateBuilder builder) {
        this.template = builder
                .uriTemplateHandler(new DefaultUriBuilderFactory(statsServerUrl))
                .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                .build();
    }

    public void save(EndpointHitDto hitDto) {
        HttpEntity<EndpointHitDto> entity = new HttpEntity<>(hitDto);
        template.postForEntity("/hit", entity, EndpointHitDto.class);
    }

    public List<ViewStatsDto> get(String app, String start, String end, List<String> uris, Boolean unique) {
        String uri = "/stats";
        Map<String, Object> params = Map.of(
                "app", app,
                "start", start,
                "end", end,
                "uris", uris,
                "unique", unique);
        return template.exchange(uri,
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<List<ViewStatsDto>>() {
                        },
                        params)
                .getBody();
    }
}
