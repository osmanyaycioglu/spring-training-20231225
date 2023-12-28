package com.training.project.employee.bussiness.services.models;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long            employeeId;
    private String          employeeUID;
    private String          firstName;
    private String          lastName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Phone>      phoneList;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Address>    addressList;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;

    @PrePersist
    public void init() {
        employeeUID = UUID.randomUUID()
                          .toString();
    }

}
