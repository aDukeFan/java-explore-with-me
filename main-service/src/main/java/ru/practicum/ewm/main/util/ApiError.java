package ru.practicum.ewm.main.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class ApiError {
    List<String> errors;
    String message;
    String reason;
    String status; // Enum дописать
    String timestamp;
}
