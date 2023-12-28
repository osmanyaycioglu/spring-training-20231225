package com.training.project.employee.bussiness.services;

import com.training.project.employee.bussiness.facades.EmployeeOperationsFacade;
import com.training.project.employee.bussiness.services.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeProvisionService {
    private final EmployeeOperationsFacade employeeOperationsFacade;

    public String add(Employee employeeParam){
        return employeeOperationsFacade.checkAndAddEmployee(employeeParam);
    }

}
