package com.training.project.employee.bussiness.services.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class EmployeeDetails {
    @Id
    @GeneratedValue
    private Long   empId;
    private String department;
    private String gender;
}
