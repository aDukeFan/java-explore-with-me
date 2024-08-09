package ru.practicum.ewm.main.mapper;

import org.mapstruct.Mapper;
import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.model.User;
import ru.practicum.ewm.main.request.NewUserRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toSave(NewUserRequest request);

    UserDto toShow(User user);
}
