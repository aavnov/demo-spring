package ru.rt.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rt.demo.dto.UserMapper;
import ru.rt.demo.dto.user.NewUserRequest;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.exception.NotFoundException;
import ru.rt.demo.exception.UserAlreadyExistException;
import ru.rt.demo.messages.ExceptionMessages;
import ru.rt.demo.messages.LogMessages;
import ru.rt.demo.repository.UserRepository;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createdUser(NewUserRequest userDto) {
        if(userRepository.existsUserByEmail(UserMapper.toUser(userDto).getEmail()))
            throw new UserAlreadyExistException(String.valueOf(ExceptionMessages.USER_ALREADY_EXISTS));

        log.debug(String.valueOf(LogMessages.ADD), "ПОЛЬЗОВАТЕЛЬ");
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(userDto)));
    }
}
