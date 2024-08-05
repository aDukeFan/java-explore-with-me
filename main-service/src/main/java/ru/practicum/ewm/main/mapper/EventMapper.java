package ru.practicum.ewm.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.EventShortDto;
import ru.practicum.ewm.main.dto.NewEventDto;
import ru.practicum.ewm.main.model.Event;
import ru.practicum.ewm.main.model.State;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(source = "newEventDto.category", target = "category.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "eventDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "locationId", target = "location.id")
    @Mapping(source = "state", target = "state")
    Event toSave(State state,
                 Integer locationId,
                 LocalDateTime createdOn,
                 Integer userId,
                 NewEventDto newEventDto);

    @Mapping(source = "event.user.name", target = "initiator.name")
    EventFullDto toShowWhileSave(Event event);

    EventShortDto toShowByUser(Event event);
}
