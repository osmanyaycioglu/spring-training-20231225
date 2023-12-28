package com.training.project.employee.input.rest.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressDto {
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    @NotEmpty
    private String addressText;

}
