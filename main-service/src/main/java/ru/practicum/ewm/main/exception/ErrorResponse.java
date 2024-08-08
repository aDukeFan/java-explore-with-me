package ru.practicum.ewm.main.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    HttpStatus status;
    String reason;
    String message;
    String timestamp;
}
