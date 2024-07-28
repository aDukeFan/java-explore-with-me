package ru.practicum.mapper;

import dto.EndpointHitDto;
import org.mapstruct.Mapper;
import ru.practicum.model.EndpointHit;

@Mapper(componentModel = "spring")
public interface EndpointHitMapper {

    EndpointHit toSave(EndpointHitDto hitDto);
}
