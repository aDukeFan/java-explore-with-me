package ru.practicum.ewm.main.mapper;

import org.mapstruct.Mapper;
import ru.practicum.ewm.main.dto.ParticipationRequestDto;
import ru.practicum.ewm.main.model.ParticipationRequest;

@Mapper(componentModel = "spring")
public interface ParticipationRequestMapper {
    ParticipationRequestDto toShow(ParticipationRequest request);
}
