package ru.rt.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.rt.demo.dto.UserMapper;
import ru.rt.demo.dto.user.NewUserRequest;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.exception.UserAlreadyExistException;
import ru.rt.demo.messages.ExceptionMessages;
import ru.rt.demo.messages.LogMessages;
import ru.rt.demo.model.User;
import ru.rt.demo.repository.UserRepository;
import ru.rt.demo.service.UserService;
import ru.rt.demo.util.GetPagable;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto registerUser(NewUserRequest userDto) {
        if (userRepository.existsUserByEmail(UserMapper.toUser(userDto).getEmail()))
            throw new UserAlreadyExistException(ExceptionMessages.USER_ALREADY_EXISTS);

        log.debug(String.valueOf(LogMessages.ADD), "ПОЛЬЗОВАТЕЛЬ");
        return UserMapper.toUserDto(userRepository.save(UserMapper.toUser(userDto)));
    }

    @Override
    public List<UserDto> getAllUsers(List<Long> ids, Integer from, Integer size) {
        Page<User> users;
        if (ids == null) {
            users = userRepository.findAll(GetPagable.of(from, size));
        } else {
            users = userRepository.findAllByIdIn(ids, PageRequest.of(from / size, size));
        }

        log.debug(String.valueOf(LogMessages.GET_ALL), "ПОЛЬЗОВАТЕЛЕЙ");
        return users.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }
}