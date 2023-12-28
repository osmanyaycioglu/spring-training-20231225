package com.training.project.employee.input.rest.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PhoneDto {
    @Size(min = 3)
    @NotEmpty
    private String phoneName;
    @Size(min = 7,max = 11)
    @NotEmpty
    private String phoneNumber;

}
