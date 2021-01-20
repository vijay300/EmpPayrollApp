package com.bridzelabz.employeepayrollapp.services;

import com.bridzelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridzelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridzelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollDataList.stream()
                                      .filter(empData -> empData.getEmployeeId() == empId)
                                      .findFirst()
                                      .orElseThrow(() -> new EmployeePayrollException("Employee Not Found for Id: " + empId));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(empId-1, employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataList.stream()
                .filter(empData -> empData.getEmployeeId() == empId)
                .findAny()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found for Id: " + empId));
        employeePayrollDataList.remove(empId-1);
    }
}
