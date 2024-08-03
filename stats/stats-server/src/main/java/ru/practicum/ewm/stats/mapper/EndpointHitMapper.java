package ru.practicum.ewm.stats.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewm.dto.stats.EndpointHitDto;
import ru.practicum.ewm.stats.model.EndpointHit;

@Mapper(componentModel = "spring")
public interface EndpointHitMapper {

    @Mapping(target = "timestamp", source = "hitDto.timestamp", dateFormat = "yyyy-MM-dd HH:mm:ss")
    EndpointHit toSave(EndpointHitDto hitDto);
}
