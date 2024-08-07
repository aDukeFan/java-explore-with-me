package ru.practicum.ewm.main.service;

import ru.practicum.ewm.main.dto.CategoryDto;

import java.util.List;

public interface PublicService {

    List<CategoryDto> getCategories(Integer from, Integer size);

    CategoryDto getCategoryById(Integer id);

}
