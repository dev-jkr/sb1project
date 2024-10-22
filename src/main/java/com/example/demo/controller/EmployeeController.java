package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee,Model model) {
		Integer id=service.saveEmployee(employee);
		String message=new StringBuffer().append("Employee ").append(id).append(" Saved").toString();
		model.addAttribute("message",message);
		return "EmployeeRegister";
	}
	@GetMapping("/all")
	public String showAll(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list",list);
		return "EmployeeData";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id,Model model) {
		service.deleteEmployee(id);
		model.addAttribute("message","Employee"+id+"Deleted");
		model.addAttribute("list", service.getAllEmployees());
		return "EmployeeData";
	}
}
