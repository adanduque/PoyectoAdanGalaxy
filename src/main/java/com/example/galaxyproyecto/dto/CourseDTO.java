package com.example.galaxyproyecto.dto;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Integer idCourse;

    @NotEmpty
    @Size(max = 20, message = "{firstname.size}")
    private String name;

    @NotNull
    @Size( message = "{lastname.size}")
    private Integer state;

    /*@Max(1)
    @Min(34)
    private Integer edad;

    @Pattern(regexp = "")
    private String test;*/
}
