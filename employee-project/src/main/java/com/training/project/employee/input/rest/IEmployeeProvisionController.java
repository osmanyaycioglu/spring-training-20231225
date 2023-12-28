package com.training.project.employee.input.rest;

import com.training.project.employee.input.rest.models.EmployeeAddResponse;
import com.training.project.employee.input.rest.models.EmployeeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@RequestMapping("/api/v1/employee/provision")
public interface IEmployeeProvisionController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "bu büyük açıklama", summary = "küçük açıklama", responses = {
            @ApiResponse(description = "bu dönecek", responseCode = "201", useReturnTypeSchema = true)
    })
    public EmployeeAddResponse add(@Valid @RequestBody EmployeeDto employeeDtoParam);
}
