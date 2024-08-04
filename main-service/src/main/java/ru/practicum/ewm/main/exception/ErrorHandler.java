package ru.practicum.ewm.main.exception;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ValidationException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException exception) {
        String message = "Field: " + Objects.requireNonNull(exception.getFieldError()).getField()
                + ". Error: " + exception.getFieldError().getDefaultMessage()
                + ". Value: " + exception.getFieldError().getRejectedValue();
        return new ErrorResponse()
                .setStatus(HttpStatus.BAD_REQUEST)
                .setReason("Incorrectly made request.")
                .setMessage(message)
                .setTimestamp(timestamp);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handle(final SQLException exception) {
        String message = "Database Error, 'cause bad data";
        return new ErrorResponse()
                .setStatus(HttpStatus.CONFLICT)
                .setReason("Integrity constraint has been violated.")
                .setMessage(message)
                .setTimestamp(timestamp);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleDelete(EmptyResultDataAccessException exception) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(Objects.requireNonNull(exception.getMessage()));
        StringBuilder builder = new StringBuilder();
        builder.append("User with id=");
        while (matcher.find()) {
            builder.append(matcher.group());
        }
        builder.append(" was not found");
        return new ErrorResponse()
                .setStatus(HttpStatus.NOT_FOUND)
                .setReason("The required object was not found.")
                .setMessage(builder.toString())
                .setTimestamp(timestamp);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleGetUsers(MethodArgumentTypeMismatchException exception) {
        return new ErrorResponse()
                .setStatus(HttpStatus.BAD_REQUEST)
                .setReason("Incorrectly made request.")
                .setMessage(exception.getMessage())
                .setTimestamp(timestamp);
    }
}
