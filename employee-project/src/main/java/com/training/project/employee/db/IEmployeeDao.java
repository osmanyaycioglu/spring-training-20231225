package com.training.project.employee.db;

import com.training.project.employee.bussiness.services.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeDao extends JpaRepository<Employee,Long> {
}
