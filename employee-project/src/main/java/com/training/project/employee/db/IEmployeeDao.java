package com.training.project.employee.db;

import com.training.project.employee.bussiness.services.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {

    Employee findByEmployeeUID(String empUid);

    List<Employee> findByLastNameOrderByLastName(String lastName);

    List<Employee> findByLastNameIn(List<String> lastNames);

    List<Employee> findByLastNameLikeIgnoreCase(String name);

    List<Employee> findByFirstNameAndLastNameOrderByFirstName(String firsName,
                                                              String LastName);

}
