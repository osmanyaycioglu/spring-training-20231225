package com.training.project.employee.bussiness.services.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Getter
@Setter
@Entity
@Table(name = "employee_phone")
public class Phone {
    @Id
    @GeneratedValue
    private Long phoneId;
    private String phoneName;
    private String phoneNumber;

}
