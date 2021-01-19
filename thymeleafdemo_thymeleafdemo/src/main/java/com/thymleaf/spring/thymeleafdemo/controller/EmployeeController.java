package com.thymleaf.spring.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thymleaf.spring.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load the employee data

	private List<Employee> theEmployee;

	@PostConstruct
	private void loadData() {

		// create employees
		Employee emp1 = new Employee(1, "Pritam", "Raj", "pritamraj@gmail.com");
		Employee emp2 = new Employee(2, "pankaj", "kumar", "pankajkumar@gmail.com");

		Employee emp3 = new Employee(3, "Amitesh", "Raj", "amiteshmraj@gmail.com");

		// create the list
		theEmployee = new ArrayList<>();
		// add to the list

		theEmployee.add(emp1);
		theEmployee.add(emp2);
		theEmployee.add(emp3);
	}

	// add mapping for "/list
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		theModel.addAttribute("employee",theEmployee);
		return "list-employee";
	}

}
