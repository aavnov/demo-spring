package ru.rt.demo.dto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.rt.demo.messages.ExceptionMessages;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;


@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class UserUpdatetDto {
    @Size(min = 6)
    @Size(max = 254)
    String email;

    @Size(min = 6)
    @Size(max = 254)
    String name;
}
