package com.example.EmployeeDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.EmployeeDB.model.Employee;
import com.example.EmployeeDB.service.EmployeeService;

@Controller
public class EmployeeController 

{
	@Autowired
	private  EmployeeService employeeService;
	
	//display list of employee
	@GetMapping("/")
	public String viewHomepage(Model model) 
	{
		model.addAttribute("listEmployees", employeeService.getAllEmployee() );
		return "index";
	}
   @GetMapping("/newemployeeadd")
	public String newemployeeadd(Model model)
   {
	   Employee employee = new Employee();
	   model.addAttribute("employee",employee);
	   return "newemployee";
	}
   
   @PostMapping("/saveemployee")
   public String saveemployee(@ModelAttribute("employee") Employee employee)
   {
	   //save employee to database
	   employeeService.saveemployee(employee);
	   return "redirect:/";
   }
   
   @GetMapping("/update/{id}")
   public String update(@PathVariable(value = "id") long id,Model model)
   {
	   Employee employee = employeeService.getEmployeeById(id);
	   model.addAttribute("employee",employee);
	   return "upadatepage";
   }
   
   @GetMapping("/delete/{id}")
   public String delete(@PathVariable (value ="id") long id)
   {
	   this.employeeService.deleteEmployeeById(id);
	   return "redirect:/";
   }
}
