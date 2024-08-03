package ru.practicum.ewm.dto.stats;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EndpointHitDto {
    String app;
    String uri;
    String ip;
    String timestamp;
}