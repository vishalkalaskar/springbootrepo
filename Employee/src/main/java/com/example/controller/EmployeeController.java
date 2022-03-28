package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.EmployeeService;

@Controller
public class EmployeeController 
{ 
	   @Autowired
	   private EmployeeService employeeservice;
	
	   @GetMapping("/")
       public String viewHomepage(Model model)
       {  
		   model.addAttribute("listEmployees", employeeservice.getAllEmployee());
    	   return "index";
       }
}
