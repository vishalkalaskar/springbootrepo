package com.example.EmployeeDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeDB.model.Employee;
import com.example.EmployeeDB.repository.EmployeeRepository;

@Service

public class EmployeeServicesImpl implements EmployeeService
{

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee>  getAllEmployee()
	{
		return employeeRepository.findAll();
	}

	@Override
	public void saveemployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) 
		{
			employee = optional.get();
			
		
		}
		else
		{
			throw new RuntimeException("Employee nt found for id :: " +id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id)
	{
		this.employeeRepository.deleteById(id);
		
		
	}
	
}
