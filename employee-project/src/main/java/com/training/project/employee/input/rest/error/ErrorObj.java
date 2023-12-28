package com.training.project.employee.input.rest.error;


import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Builder(setterPrefix = "with")
@Jacksonized
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String errorDesc;
    private Integer errorCode;
}
