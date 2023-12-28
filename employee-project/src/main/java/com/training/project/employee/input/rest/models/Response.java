package com.training.project.employee.input.rest.models;

import lombok.Data;

@Data
public class Response<T> {

    private boolean errorOccured;
    private String error;
    private T response;

}
