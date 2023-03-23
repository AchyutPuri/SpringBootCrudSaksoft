package com.sacksoft.task.service;

import java.util.List;

import com.sacksoft.task.entity.Employee;

public interface EmployeeService {

	public String saveEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public Employee getById(Integer eid);
	
	public List<Employee> getAllEmployee();
	
	public String deleteById(Integer eid);
	
}
