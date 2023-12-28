package com.training.project.employee.bussiness.services.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@Entity
@Table(name = "employee_address")
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;
    private String city;
    private String street;
    private String addressText;

}
