package com.training.project.employee.bussiness.services.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Phone {
    private String phoneName;
    private String phoneNumber;

}
