package com.training.project.employee.bussiness.services.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeCredentials {
    @Id
    @GeneratedValue
    private Long creId;
    @Size(min = 6,max = 15)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Long empId;
}
