package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.EmployeeModel;
import com.example.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService

{
	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public List<EmployeeModel> getAllEmployee() 
	{
		
		return employeerepository.findAll() ;
	}
  

}
