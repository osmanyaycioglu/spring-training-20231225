package com.training.project.employee.integrations.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Data

public class Person {
    private String  firstName;
    private String  lastName;
    private Integer age;
    private Integer height;
    private Integer weight;

    public Person() {
    }

    @Builder(setterPrefix = "with")
    public Person(final String firstName,
                  final String lastName,
                  final Integer age,
                  final Integer height,
                  final Integer weight) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
        this.height    = height;
        this.weight    = weight;
    }
}
