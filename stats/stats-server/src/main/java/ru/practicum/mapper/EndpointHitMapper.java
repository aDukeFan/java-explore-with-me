package ru.practicum.mapper;

import dto.EndpointHitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.model.EndpointHit;

@Mapper(componentModel = "spring")
public interface EndpointHitMapper {

    @Mapping(target="timestamp", source="hitDto.timestamp", dateFormat="yyyy-MM-dd HH:mm:ss")
    EndpointHit toSave(EndpointHitDto hitDto);
}
