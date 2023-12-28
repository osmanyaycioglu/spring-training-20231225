package com.training.project.employee.bussiness.services.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Address {
    private String city;
    private String street;
    private String addressText;

}
