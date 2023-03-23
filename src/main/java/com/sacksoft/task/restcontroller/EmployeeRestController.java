package com.sacksoft.task.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sacksoft.task.entity.Employee;
import com.sacksoft.task.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
	{
		String fname=employee.getFirstName();
		String status=employeeService.saveEmployee(employee);
		
		return new ResponseEntity<>(status,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/employee/{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer eid)
	{
		Employee employee=employeeService.getById(eid);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> allEmployees=employeeService.getAllEmployee();
		return new ResponseEntity<>(allEmployees,HttpStatus.OK);	
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee employee1=employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee1,HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eid)
	{
		String status=employeeService.deleteById(eid);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
}
