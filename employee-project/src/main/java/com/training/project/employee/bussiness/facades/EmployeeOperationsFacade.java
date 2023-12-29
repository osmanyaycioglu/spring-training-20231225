package com.training.project.employee.bussiness.facades;

import com.training.project.employee.bussiness.services.models.Employee;
import com.training.project.employee.db.EmployeeRepository;
import com.training.project.employee.integrations.TrainingIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeOperationsFacade {
    private final TrainingIntegration trainingIntegration;
    private final EmployeeRepository employeeRepository;

    public String checkAndAddEmployee(Employee employeeParam){
        if (trainingIntegration.requestPersonInfo(employeeParam)){
            return employeeRepository.insertEmployee(employeeParam);
        } else {
            throw new IllegalStateException("person is not ready");
        }
    }


    public Employee findOneByUid(final String empIdParam) {
        return employeeRepository.findOneByUid(empIdParam);
    }
}
