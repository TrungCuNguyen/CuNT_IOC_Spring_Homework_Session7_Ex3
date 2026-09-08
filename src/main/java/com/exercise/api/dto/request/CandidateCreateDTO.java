package com.exercise.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateCreateDTO {
    @NotBlank(message = "Full Name cannot be empty")
    @Size(min = 5, max = 50, message = "Full Name must be between 5 and 50 characters")
    private String fullName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotNull(message = "Years of experience cannot be null")
    @Min(value = 0, message = "Years of experience must be >= 0")
    private Integer yearsOfExperience;
}
