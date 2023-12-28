package com.training.project.employee.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.project.employee.input.rest.models.EmployeeAddResponse;
import com.training.project.employee.input.rest.models.EmployeeDto;
import com.training.project.employee.input.rest.models.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class EmployeeProvisionController implements IEmployeeProvisionController {

    public EmployeeAddResponse add(EmployeeDto employeeDtoParam) {
        return null;
    }

    // Yapma
//    @PostMapping("/add")
//    public Response<EmployeeAddResponse> add(@RequestBody EmployeeDto employeeDtoParam){
//
//    }
//
//    @PostMapping("/operation/{op}")
//    public ResponseEntity<?> add(@PathVariable String op, HttpServletRequest requestParam) throws IOException {
//        switch (op){
//            case "add":
//                ObjectMapper objectMapperLoc = new ObjectMapper();
//                objectMapperLoc.readValue(requestParam.getInputStream(), EmployeeDto.class);
//                // iş
//                EmployeeAddResponse employeeAddResponseLoc = new EmployeeAddResponse();
//                return ResponseEntity.status(HttpStatus.CREATED).body(employeeAddResponseLoc);
//        }
//    }

}
