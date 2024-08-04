package ru.practicum.ewm.main.mapper;

import org.mapstruct.Mapper;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.NewCategoryDto;
import ru.practicum.ewm.main.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toSave(NewCategoryDto categoryDto);

    CategoryDto toShow(Category category);
}
