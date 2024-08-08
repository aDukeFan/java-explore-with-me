package ru.practicum.ewm.main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.NewCategoryDto;
import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.mapper.CategoryMapper;
import ru.practicum.ewm.main.mapper.UserMapper;
import ru.practicum.ewm.main.model.Category;
import ru.practicum.ewm.main.model.User;
import ru.practicum.ewm.main.repository.CategoryRepository;
import ru.practicum.ewm.main.repository.UserRepository;
import ru.practicum.ewm.main.request.NewUserRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public UserDto saveUser(NewUserRequest newUserRequest) {
        return userMapper.toShow(userRepository.save(userMapper.toSave(newUserRequest)));
    }

    @Override
    public List<UserDto> getUsers(Integer[] ids, Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from / size, size);
        List<User> users = new ArrayList<>();
        if (ids != null) {
            users.addAll(userRepository.findAllByIdIn(ids, pageable));
        } else {
            users.addAll(userRepository.findAll(pageable).toList());
        }
        return users.stream().map(userMapper::toShow).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public CategoryDto saveCategory(NewCategoryDto newCategoryDto) {
        return categoryMapper.toShow(categoryRepository.save(categoryMapper.toSave(newCategoryDto)));
    }

    @Override
    public void deleteCategory(Integer catId) {
        categoryRepository.deleteById(catId);
    }

    @Override
    public CategoryDto updateCategory(Integer catId, NewCategoryDto newCategoryDto) {
        Category categoryToUpdate = categoryRepository.findById(catId).orElse(null);
        assert categoryToUpdate != null;
        categoryToUpdate.setName(newCategoryDto.getName());
        return categoryMapper.toShow(categoryRepository.save(categoryToUpdate));
    }
}
