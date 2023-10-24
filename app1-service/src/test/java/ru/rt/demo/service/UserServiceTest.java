package ru.rt.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rt.demo.model.User;
import ru.rt.demo.repository.UserRepository;
import ru.rt.demo.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userUtilService;
    private final long userId = 1L;
    private User expectedUser;
    private String expectedErrMessage;

    @BeforeEach
    void setUp() {
        expectedUser = User.builder()
                .name("Name")
                .email("email@mail.ru")
                .build();
    }



    @Test
    void registerUser() {
    }

    @Test
    void getUsers() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}