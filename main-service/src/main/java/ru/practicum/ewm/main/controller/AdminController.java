package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.dto.CategoryDto;
import ru.practicum.ewm.main.dto.CompilationDto;
import ru.practicum.ewm.main.dto.EventFullDto;
import ru.practicum.ewm.main.dto.NewCategoryDto;
import ru.practicum.ewm.main.dto.NewCompilationDto;
import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.request.NewUserRequest;
import ru.practicum.ewm.main.request.UpdateEventAdminRequest;
import ru.practicum.ewm.main.service.AdminService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/admin")
@AllArgsConstructor
public class AdminController {

    public final AdminService service;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@Valid @RequestBody NewUserRequest newUserRequest) {
        return service.saveUser(newUserRequest);
    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer userId) {
        service.deleteUser(userId);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam(defaultValue = "null", required = false) Integer[] ids,
                                  @RequestParam(defaultValue = "0", required = false) Integer from,
                                  @RequestParam(defaultValue = "10", required = false) Integer size) {
        return service.getUsers(ids, from, size);
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto saveCategory(@Valid @RequestBody NewCategoryDto newCategoryDto) {
        return service.saveCategory(newCategoryDto);
    }

    @DeleteMapping("/categories/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Integer catId) {
        service.deleteCategory(catId);
    }

    @PatchMapping("/categories/{catId}")
    public CategoryDto updateCategory(@PathVariable Integer catId,
                                      @Valid @RequestBody NewCategoryDto newCategoryDto) {
        return service.updateCategory(catId, newCategoryDto);
    }

    @GetMapping("/events")
    public List<EventFullDto> getEventsWithParams(@RequestParam Integer[] users,
                                                  @RequestParam String[] states,
                                                  @RequestParam Integer[] categories,
                                                  @RequestParam String rangeStart,
                                                  @RequestParam String rangeEnd,
                                                  @RequestParam(defaultValue = "0", required = false) Integer from,
                                                  @RequestParam(defaultValue = "10", required = false) Integer size) {
        return null;
    }

    @PatchMapping("/events/{eventId}")
    public EventFullDto correctEvent(@PathVariable Integer eventId,
                                     @RequestBody UpdateEventAdminRequest request) {
        return null;
    }

    @PostMapping("/compilations")
    public CompilationDto addNewCompilation(@RequestBody NewCompilationDto newCompilationDto) {
        return null;
    }

    @DeleteMapping("/compilations/{compId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompilation(@PathVariable Integer compId) {
    }

    @PatchMapping("/compilations/{compId}")
    public CompilationDto updateCompilation(@PathVariable Integer compId) {
        return null;
    }
}
