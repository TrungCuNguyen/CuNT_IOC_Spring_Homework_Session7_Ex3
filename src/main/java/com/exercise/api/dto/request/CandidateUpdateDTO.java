package com.exercise.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateUpdateDTO {
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @Size(min = 10, max = 200, message = "size must be between 10 and 200")
    private String bio;
}
