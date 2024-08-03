package ru.practicum.ewm.main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.mapper.UserMapper;
import ru.practicum.ewm.main.repository.UserRepository;
import ru.practicum.ewm.main.request.NewUserRequest;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto saveUser(NewUserRequest newUserRequest) {
        return userMapper.toShow(userRepository.save(userMapper.toSave(newUserRequest)));
    }

    @Override
    public List<UserDto> getUsers(Integer from, Integer size) {
        return List.of();
    }

    @Override
    public String deleteUser(Integer userId) {
        return "";
    }
}
