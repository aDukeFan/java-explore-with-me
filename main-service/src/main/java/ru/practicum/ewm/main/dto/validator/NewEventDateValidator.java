package ru.practicum.ewm.main.dto.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewEventDateValidator implements ConstraintValidator<EventDate, String> {

    @Override
    public boolean isValid(String eventDateTimeString, ConstraintValidatorContext context) {
        try {
            LocalDateTime eventDateTime = LocalDateTime.parse(eventDateTimeString,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime now = LocalDateTime.now();
            return !eventDateTime.isBefore(now);
        } catch (Exception e) {
            return false;
        }
    }
}
