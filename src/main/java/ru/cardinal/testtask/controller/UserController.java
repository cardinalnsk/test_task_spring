package ru.cardinal.testtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cardinal.testtask.model.User;
import ru.cardinal.testtask.service.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Object> getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable Long id) {
        return userService.updateUser(id);
    }
}
