package ru.job4j.chat.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.chat.exception.InvalidIdException;
import ru.job4j.chat.exception.NoEnoughUsersException;
import ru.job4j.chat.model.User;
import ru.job4j.chat.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/users/")
@Slf4j
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    public UserController(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) throws InvalidIdException, NoEnoughUsersException {
        if (userService.findAll().isEmpty()) {
            throw new NoEnoughUsersException("not enough users in db");
        }
        if (id > 1000) {
            throw new InvalidIdException("invalid id");
        }
        return ResponseEntity.of(Optional.of(userService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "user not found")
                )));
    }

    @ExceptionHandler(value = {NoEnoughUsersException.class})
    public void exceptionHandler(Exception e, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {
            {
                put("message", e.getMessage());
                put("type", e.getClass());
            }
        }));
        log.error(e.getLocalizedMessage());
    }
}
