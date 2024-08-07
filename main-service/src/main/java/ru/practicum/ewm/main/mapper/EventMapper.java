package ru.practicum.ewm.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.EventShortDto;
import ru.practicum.ewm.main.dto.NewEventDto;
import ru.practicum.ewm.main.model.Event;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "eventDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "location", ignore = true)
    Event toSave(NewEventDto newEventDto);

    @Mapping(target = "initiator.name", source = "event.user.name")
    @Mapping(target = "eventDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "createdOn", dateFormat = "yyyy-MM-dd HH:mm:ss")
    EventFullDto toShowWhileSave(Event event);

    EventShortDto toShowByUser(Event event);
}
