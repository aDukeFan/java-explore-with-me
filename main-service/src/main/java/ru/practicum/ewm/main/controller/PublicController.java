package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.service.PublicService;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class PublicController {

    private final PublicService service;

    @GetMapping("/categories")
    public List<CategoryDto> getCategories(@RequestParam(defaultValue = "0", required = false) Integer from,
                                           @RequestParam(defaultValue = "10", required = false) Integer size) {
        return service.getCategories(from, size);
    }

    @GetMapping("/categories/{catId}")
    public CategoryDto getCategoryById(@PathVariable Integer catId) {
        return service.getCategoryById(catId);
    }
}
