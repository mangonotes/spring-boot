package com.example.demo.service.employee;

import com.example.demo.ui.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    void insert(EmployeeDTO employeeDto);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployeeById(Integer id);

}
