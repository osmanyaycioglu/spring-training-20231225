package com.training.project.employee.input.rest.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder(setterPrefix = "with")
@Jacksonized
public class EmployeeAddResponse {
    private String employeeId;
    private String desc;
}
