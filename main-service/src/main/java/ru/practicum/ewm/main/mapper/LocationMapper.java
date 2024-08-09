package ru.practicum.ewm.main.mapper;

import org.mapstruct.Mapper;
import ru.practicum.ewm.main.dto.LocationDto;
import ru.practicum.ewm.main.model.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location toSave(LocationDto locationDto);

    LocationDto toShow(Location location);
}
