package ru.practicum.ewm.main.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.mapper.CategoryMapper;
import ru.practicum.ewm.main.model.Category;
import ru.practicum.ewm.main.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicServiceImpl implements PublicService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getCategories(Integer from, Integer size) {
        Pageable pageable = PageRequest.of(from / size, size);
        List<Category> categories = categoryRepository.findAll(pageable).toList();
        List<CategoryDto> result = new ArrayList<>();
        categories.forEach(category -> result.add(categoryMapper.toShow(category)));
        return result;
    }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        return categoryMapper.toShow(categoryRepository.findById(id).orElse(null));
    }
}
