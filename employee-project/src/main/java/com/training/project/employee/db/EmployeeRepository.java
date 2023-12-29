package com.training.project.employee.db;

import com.training.project.employee.bussiness.services.models.Employee;
import com.training.project.employee.bussiness.services.models.EmployeeCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final IEmployeeDao            employeeDao;
    private final IEmployeeCredentialsDao employeeCredentialsDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String insertEmployee(Employee employeeParam) {
        Employee            savedEmployeeLoc       = employeeDao.save(employeeParam);
        EmployeeCredentials employeeCredentialsLoc = employeeParam.getEmployeeCredentials();
        employeeCredentialsLoc.setEmpId(savedEmployeeLoc.getEmployeeId());
        employeeCredentialsDao.save(employeeCredentialsLoc);
        // code ...
        return employeeParam.getEmployeeUID();
    }

    public Employee findOneByUid(final String empIdParam) {
        return employeeDao.findByEmployeeUID(empIdParam);
    }
}
