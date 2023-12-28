package com.training.project.employee.input.rest.models;


import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private String           name;
    private String           surname;
    private List<PhoneDto>   phoneList;
    private List<AddressDto> addressList;
    private String           department;
}
