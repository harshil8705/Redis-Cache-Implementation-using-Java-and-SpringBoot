package com.harshilInfotech.cacheTut.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    @Digits(integer = 2, fraction = 1)
    private Double experience;

    @NotNull
    private Double salary;

}
