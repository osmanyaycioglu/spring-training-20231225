package com.training.project.employee.input.rest.models;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class EmployeeDto {
    @NotEmpty
    @Schema(name = "name",description = "çalışanın ismi",example = "osman")
    private String           name;
    @NotBlank
    private String           surname;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<PhoneDto>   phoneList;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<AddressDto> addressList;
    @NotEmpty
    private String           department;
}
