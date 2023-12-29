package com.training.project.employee.bussiness.facades;

import com.training.project.employee.bussiness.services.models.Employee;
import com.training.project.employee.db.EmployeeRepository;
import com.training.project.employee.integrations.TrainingIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeOperationsFacade {
    private final TrainingIntegration trainingIntegration;
    private final EmployeeRepository  employeeRepository;

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = {NullPointerException.class,
                                                                        IllegalArgumentException.class
    }, isolation = Isolation.READ_COMMITTED)
    public String checkAndAddEmployee(final Employee employeeParam) {
        if (this.trainingIntegration.requestPersonInfo(employeeParam)) {
            final String stringLoc = this.employeeRepository.insertEmployee(employeeParam);
            // Another Rest Call
            return stringLoc;
        } else {
            throw new IllegalStateException("person is not ready");
        }
    }


    public Employee findOneByUid(final String empIdParam) {
        return this.employeeRepository.findOneByUid(empIdParam);
    }
}
