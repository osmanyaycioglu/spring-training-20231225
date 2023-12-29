package com.training.project.employee.db;

import com.training.project.employee.bussiness.services.models.EEmployeeStatus;
import com.training.project.employee.bussiness.services.models.Employee;
import com.training.project.employee.bussiness.services.models.EmployeeSearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.List;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {

    Employee findByEmployeeUID(String empUid);

    List<Employee> findByLastNameOrderByLastName(String lastName);

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    List<Employee> findByLastNameIn(List<String> lastNames);

    List<Employee> findByLastNameLikeIgnoreCase(String name);

    List<Employee> findByFirstNameAndLastNameOrderByFirstName(String firsName,
                                                              String LastName);

    @Query("select e from Employee e where e.lastName=?1")
    List<Employee> searchLastName(String lastName);

    @Query("select e from Employee e where e.lastName=?1 and e.firstName=?2")
    List<Employee> searchLastNameAndFirstName(String lastName,
                                              String firstName);

    @Query(value = "select * from employee e where e.last_name=?1", nativeQuery = true)
    List<Employee> searchLastNameNative(String lastName);

    @Query("select e.firstName,e.lastName from Employee e")
    List<Object[]> getOnlyFirstNameAndLastName();

    @Query("select new com.training.project.employee.bussiness.services.models.EmployeeSearchResult(e.firstName,e.lastName,e.employeeDetails.department) from Employee e")
    List<EmployeeSearchResult> getEmployeeSearchResult();

    @Modifying
    @Query("update Employee e set e.employeeStatus=?1 where e.employeeId=?2")
    void updateEmployeeStatus(EEmployeeStatus employeeStatusParam,
                              Long employeeId);
}
