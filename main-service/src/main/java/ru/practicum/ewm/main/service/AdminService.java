package ru.practicum.ewm.main.service;

import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.NewCategoryDto;
import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.request.NewUserRequest;

import java.util.List;

public interface AdminService {

    UserDto saveUser(NewUserRequest newUserRequest);

    List<UserDto> getUsers(Integer[] ids, Integer from, Integer size);

    void deleteUser(Integer userId);

    CategoryDto saveCategory(NewCategoryDto newCategoryDto);

    void deleteCategory(Integer catId);

    CategoryDto updateCategory(Integer catId, NewCategoryDto newCategoryDto);

}
