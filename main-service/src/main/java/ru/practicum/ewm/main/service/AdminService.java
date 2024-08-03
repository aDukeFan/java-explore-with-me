package ru.practicum.ewm.main.service;

import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.request.NewUserRequest;

import java.util.List;

public interface AdminService {

    UserDto saveUser(NewUserRequest newUserRequest);

    List<UserDto> getUsers(Integer from, Integer size);

    String deleteUser(Integer userId);

}
