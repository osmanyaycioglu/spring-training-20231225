package com.training.project.employee.bussiness.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSearchResult {
    private String name;
    private String surname;
    private String department;
}
