package com.training.project.employee.db;

import com.training.project.employee.bussiness.services.models.EmployeeCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeCredentialsDao extends JpaRepository<EmployeeCredentials, Long> {

}
