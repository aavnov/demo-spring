package ru.rt.demo.dto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.rt.demo.messages.ExceptionMessages;

import javax.validation.constraints.NotBlank;
import java.util.Optional;


@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class UserUpdatetDto {
    String email;

    @NotBlank(message = ExceptionMessages.EMPTY_NAME)
    String name;
}
