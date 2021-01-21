package com.bridzelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 2000, message = "Min Wage should be more than 2000")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start Date should not empty")
    @PastOrPresent(message = "Start date should not be future date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    public String note;

    @NotBlank(message = "Profile pic cannot Empty")
    public String profilePic;

    @NotNull(message = "Departments cannot Empty")
    public List<String> departments;
}
