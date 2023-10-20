package ru.rt.demo.dto;

import lombok.experimental.UtilityClass;
import ru.rt.demo.dto.user.NewUserRequest;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.dto.user.UserShortDto;
import ru.rt.demo.model.User;

import java.util.Optional;

//import static org.graalvm.compiler.phases.common.DeadCodeEliminationPhase.Optionality.Optional;


@UtilityClass
public class UserMapper {

    public User toUser(NewUserRequest userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }


    public  User toUser1(NewUserRequest userDto){
        User user = new User();
        Optional.ofNullable(userDto.getName()).ifPresent(user::setName);
        Optional.ofNullable(userDto.getEmail()).ifPresent(user::setEmail);
        return user;
    }

    public UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

//    public UserShortDto toUserShortDto(User user) {
//        return UserShortDto.builder()
//                .id(user.getId())
//                .name(user.getName())
//                .build();
//    }

    public User toUserDto(NewUserRequest newUserRequest) {
        return User.builder()
                .name(newUserRequest.getName())
                .email(newUserRequest.getEmail())
                .build();
    }


}
