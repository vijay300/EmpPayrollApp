package com.bridzelabz.employeepayrollapp.dto;

import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 2000, message = "Min Wage should be more than 2000")
    public long salary;

    public String gender;

    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> departments;
}
