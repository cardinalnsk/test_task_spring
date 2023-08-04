package ru.cardinal.testtask.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.cardinal.testtask.exception.UserNotFoundException;
import ru.cardinal.testtask.model.User;
import ru.cardinal.testtask.repo.UserRepository;
import ru.cardinal.testtask.response.ResponseHandler;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Object> save(User user) {
//        return userRepository.save(user).getId();
        return ResponseHandler
                .responseBuilder("User was saved", HttpStatus.OK, userRepository.save(user).getId());
    }

    @Override
    public ResponseEntity<Object> findById(long id) {
        if (!userRepository.findById(id).isPresent()) {
            throw new UserNotFoundException("User does not exists");
        }
        return ResponseHandler
                .responseBuilder("User by id:%d, found".formatted(id), HttpStatus.OK, userRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Object> updateUser(long id) {
        if (!userRepository.findById(id).isPresent()) {
            throw new UserNotFoundException("User does not exists");
        }
        User usr = userRepository.findById(id).get();
        Map<String, String> updateResponse = new HashMap<>();
        updateResponse.put("id", String.valueOf(usr.getId()));
        updateResponse.put("previousStatus", usr.getStatus());
        if (usr.getStatus().equalsIgnoreCase("offline")) {
            usr.setStatus("online");
            updateResponse.put("currentStatus", usr.getStatus());
        } else {
            usr.setStatus("offline");
            updateResponse.put("currentStatus", usr.getStatus());
        }
        userRepository.save(usr);
        return ResponseHandler.responseBuilder("Change state of user", HttpStatus.OK, updateResponse);
    }
}
