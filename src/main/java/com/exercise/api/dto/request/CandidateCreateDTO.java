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
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 50)
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Dữ liệu không hợp lệ")
    private String email;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private Integer age;

    @NotNull(message = "Năm kinh nghiệm không được để trống")
    @Min(value = 0, message = "Năm kinh nghiệm không được nhỏ hơn 0")
    private Integer yearsOfExperience;
}
