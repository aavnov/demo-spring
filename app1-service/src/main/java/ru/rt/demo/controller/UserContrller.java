package ru.rt.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rt.demo.dto.user.NewUserRequest;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.exception.NotFoundException;
import ru.rt.demo.messages.LogMessages;
import ru.rt.demo.service.UserService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserContrller {
    private final UserService userService;

    @Autowired
    public UserContrller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(@Valid @RequestBody NewUserRequest newUserRequest) {
        log.debug(String.valueOf(LogMessages.TRY_ADD), "ПОЛЬЗОВАТЕЛЯ");
        return userService.createdUser(newUserRequest);
    }


}
