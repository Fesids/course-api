package com.definitivo.definitivo.DTO;

import com.definitivo.definitivo.models.Author;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public record CourseDto(
        @NotNull @NotEmpty String title,

        @NotNull @NotEmpty String category,

        @NotNull @NotEmpty String description,

        @NotNull @NotEmpty String img,

        @NotNull @DecimalMin(value = "0.0", inclusive = false) BigDecimal price,

        @NotNull  int rating




        ) {


}
