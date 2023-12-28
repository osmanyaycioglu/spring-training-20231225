package com.training.project.employee.bussiness.services.models;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Employee {
    private String          firstName;
    private String          lastName;
    private List<Phone>     phoneList;
    private List<Address>   addressList;
    private EmployeeDetails employeeDetails;
}
