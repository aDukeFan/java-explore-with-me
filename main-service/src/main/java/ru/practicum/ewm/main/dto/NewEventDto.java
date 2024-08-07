package ru.practicum.ewm.main.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.main.dto.validator.EventDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@ToString
public class NewEventDto {
    @NotBlank
    @NotNull
    @Size(min = 20, max = 2000)
    String annotation;
    Integer category;
    @NotBlank
    @NotNull
    @Size(min = 20, max = 7000)
    String description;
    @EventDate
    String eventDate;
    LocationDto location;
    Boolean paid;
    @PositiveOrZero
    Integer participantLimit;
    Boolean requestModeration;
    @Size(min = 3, max = 120)
    String title;
}
