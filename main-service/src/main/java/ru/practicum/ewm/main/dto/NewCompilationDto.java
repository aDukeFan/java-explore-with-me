package ru.practicum.ewm.main.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class NewCompilationDto {
    List<Integer> events;
    boolean pinned;
    @NotBlank
    @NotNull
    @Size(min = 1, max = 50)
    String title;

}
