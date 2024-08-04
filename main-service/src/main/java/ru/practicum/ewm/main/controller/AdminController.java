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
import ru.practicum.ewm.main.dto.NewCategoryDto;
import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.request.NewUserRequest;
import ru.practicum.ewm.main.service.AdminService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path = "/admin")
@AllArgsConstructor
public class AdminController {

    public final AdminService service;

    @PostMapping("/users")
    public UserDto saveUser(@Valid @RequestBody NewUserRequest newUserRequest) {
        return service.saveUser(newUserRequest);
    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer userId) {
        service.deleteUser(userId);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam Integer[] ids,
                                  @RequestParam Integer from,
                                  @RequestParam Integer size) {
        return service.getUsers(ids, from, size);
    }

    @PostMapping("/categories")
    public CategoryDto saveCategory(@RequestBody NewCategoryDto newCategoryDto) {
        return service.saveCategory(newCategoryDto);
    }

    @DeleteMapping("/categories/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Integer catId) {
        service.deleteCategory(catId);
    }

    @PatchMapping("/categories/{catId}")
    public CategoryDto getCategory(@PathVariable Integer catId,
                                   @RequestParam NewCategoryDto newCategoryDto) {
        return service.updateCategory(catId, newCategoryDto);
    }

//    @GetMapping("/events")
//
//    @PatchMapping("/events/{eventId}")
//
//    @PostMapping("/compilations")
//
//    @DeleteMapping("/compilations/{compId}")
//
//    @PatchMapping("/compilations/{compId}")
}
