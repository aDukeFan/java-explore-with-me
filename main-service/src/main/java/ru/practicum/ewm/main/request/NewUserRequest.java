package ru.practicum.ewm.main.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class NewUserRequest {
    @NotNull
    @Email
    @Size(min = 6, max = 254)
    String email;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 250)
    String name;
}
