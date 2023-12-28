package com.training.project.employee.db;

import com.training.project.employee.bussiness.services.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final IEmployeeDao employeeDao;

    public String insertEmployee(Employee employeeParam){
        employeeDao.save(employeeParam);
        return employeeParam.getEmployeeUID();
    }

}
