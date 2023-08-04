package ru.cardinal.testtask.service;


import org.springframework.http.ResponseEntity;
import ru.cardinal.testtask.model.User;

public interface UserService {
    ResponseEntity<Object> save(User user);
    ResponseEntity<Object> findById(long id);
    ResponseEntity<Object> updateUser(long id);
}
