package com.training.project.employee.input.objectmappings;

import com.training.project.employee.bussiness.services.models.Employee;
import com.training.project.employee.input.rest.models.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IEmployeeMappings {

    IEmployeeMappings INSTANCE = Mappers.getMapper(IEmployeeMappings.class);

    @Mapping(source = "name", target = "firstName")
    @Mapping(source = "surname", target = "lastName")
    @Mapping(source = "department", target = "employeeDetails.department")
    @Mapping(source = "gender", target = "employeeDetails.gender")
    Employee toEmployee(EmployeeDto emp);

    @Mapping(target = "name", source = "firstName")
    @Mapping(target = "surname", source = "lastName")
    @Mapping(target = "department", source = "employeeDetails.department")
    @Mapping(target = "gender", source = "employeeDetails.gender")
    EmployeeDto toEmployeeDto(Employee emp);

}
