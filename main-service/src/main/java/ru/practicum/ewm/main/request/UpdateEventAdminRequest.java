package ru.practicum.ewm.main.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.main.dto.LocationDto;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class UpdateEventAdminRequest {
    String annotation;
    Integer category;
    String description;
    LocationDto location;
    Boolean paid;
    Integer participantLimit;
    Boolean requestModeration;
    String stateAction;
    String title;
}
