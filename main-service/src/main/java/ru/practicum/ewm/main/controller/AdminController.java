package ru.practicum.ewm.main.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.dto.UserDto;
import ru.practicum.ewm.main.request.NewUserRequest;
import ru.practicum.ewm.main.service.AdminService;

import javax.validation.Valid;
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
    public String deleteUser(@PathVariable Integer userId) {
        return service.deleteUser(userId);
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam Integer from,
                                  @RequestParam Integer size) {
        return service.getUsers(from, size);
    }

}
