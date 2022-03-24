package com.example.EmployeeDB.service;

import java.util.List;

import com.example.EmployeeDB.model.Employee;

public interface EmployeeService 
{
    List<Employee> getAllEmployee();
    void saveemployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
