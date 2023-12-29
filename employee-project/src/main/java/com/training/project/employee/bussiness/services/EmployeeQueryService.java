package com.training.project.employee.bussiness.services;

import com.training.project.employee.bussiness.facades.EmployeeOperationsFacade;
import com.training.project.employee.bussiness.services.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeQueryService {
    private final EmployeeOperationsFacade employeeOperationsFacade;


    public Employee findOneByUid(final String empIdParam) {
        return employeeOperationsFacade.findOneByUid(empIdParam);
    }
}
