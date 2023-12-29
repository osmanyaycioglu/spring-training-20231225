package com.training.project.employee.input.rest;

import com.training.project.employee.bussiness.services.EmployeeQueryService;
import com.training.project.employee.bussiness.services.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee/query")
@RequiredArgsConstructor
public class EmployeeQueryController {
    private final EmployeeQueryService employeeQueryService;

    @GetMapping("/find/one")
    public Employee getOneEmployee(@RequestParam String empId){
        return employeeQueryService.findOneByUid(empId);
    }

}
