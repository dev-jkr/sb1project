package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer id);
}
