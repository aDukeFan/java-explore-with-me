package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.CompilationDto;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.EventShortDto;
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

    @GetMapping("/compilations")
    public List<CompilationDto> getCompilations(@RequestParam Boolean pinned,
                                                @RequestParam(defaultValue = "0", required = false) Integer from,
                                                @RequestParam(defaultValue = "10", required = false) Integer size) {
        return null;
    }

    @GetMapping("/compilations/{compId}")
    public CompilationDto getCompilationById(@PathVariable Integer compId) {
        return null;
    }

    @GetMapping("/events")
    public List<EventShortDto> getEventsByParams(@RequestParam String text, // без учета регистра
                                                 @RequestParam Integer[] categories,
                                                 @RequestParam Boolean paid,
                                                 @RequestParam String rangeStart, //
                                                 @RequestParam String rangeEnd,
                                                 @RequestParam Boolean onlyAvailable,
                                                 @RequestParam String sort, // EVENT_DATE, VIEWS
                                                 @RequestParam(defaultValue = "0", required = false) Integer from,
                                                 @RequestParam(defaultValue = "10", required = false) Integer size) {
        //Обратите внимание:
        //это публичный эндпоинт, соответственно в выдаче должны быть только опубликованные события
        //текстовый поиск (по аннотации и подробному описанию) должен быть без учета регистра букв
        //если в запросе не указан диапазон дат [rangeStart-rangeEnd], то нужно выгружать события, которые произойдут позже текущей даты и времени
        //информация о каждом событии должна включать в себя количество просмотров и количество уже одобренных заявок на участие
        //информацию о том, что по этому эндпоинту был осуществлен и обработан запрос, нужно сохранить в сервисе статистики
        //В случае, если по заданным фильтрам не найдено ни одного события, возвращает пустой список
        return null;
    }

    @GetMapping("/events/{id}")
    public EventFullDto getEventById(@PathVariable Integer id) {
        return null;
    }
}
