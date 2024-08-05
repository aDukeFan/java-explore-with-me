package ru.practicum.ewm.main.service;

import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.NewEventDto;

public interface UserService {

    EventFullDto saveEvent(Integer userId, NewEventDto newEventDto);


}
