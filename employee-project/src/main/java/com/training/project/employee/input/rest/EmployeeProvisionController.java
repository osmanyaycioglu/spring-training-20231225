package com.training.project.employee.input.rest;

import com.training.project.employee.bussiness.services.EmployeeProvisionService;
import com.training.project.employee.input.objectmappings.IEmployeeMappings;
import com.training.project.employee.input.rest.models.EmployeeAddResponse;
import com.training.project.employee.input.rest.models.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeProvisionController implements IEmployeeProvisionController {
    private final EmployeeProvisionService employeeProvisionService;

    @Override
    public EmployeeAddResponse add(final EmployeeDto employeeDtoParam) {
        String uid = this.employeeProvisionService.add(IEmployeeMappings.INSTANCE.toEmployee(employeeDtoParam));
        return EmployeeAddResponse.builder()
                                  .withEmployeeId(uid)
                                  .withDesc("employee active edildi")
                                  .build();
    }

    // Yapma
//    @PostMapping("/add")
//    public Response<EmployeeAddResponse> add(@RequestBody EmployeeDto employeeDtoParam){
//
//    }
//
//    @PostMapping("/operation/{op}")
//    public ResponseEntity<?> add(@PathVariable String op, HttpServletRequest requestParam) throws IOException {
//        switch (op){
//            case "add":
//                ObjectMapper objectMapperLoc = new ObjectMapper();
//                objectMapperLoc.readValue(requestParam.getInputStream(), EmployeeDto.class);
//                // iş
//                EmployeeAddResponse employeeAddResponseLoc = new EmployeeAddResponse();
//                return ResponseEntity.status(HttpStatus.CREATED).body(employeeAddResponseLoc);
//        }
//    }

}
