package com.sacksoft.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacksoft.task.entity.Employee;
import com.sacksoft.task.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "success";
	}

	
	  @Override 
	  public Employee updateEmployee(Employee employee) {
	  
	  Employee e= employeeRepository.save(employee);
	  
	  return e;
	  
	  }
	 

	@Override
	public Employee getById(Integer eid) {
		Optional<Employee> findById=employeeRepository.findById(eid);
		
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public String deleteById(Integer eid) {
		
		if(employeeRepository.existsById(eid))
		{
			employeeRepository.deleteById(eid);
			return "Delete Success";
		}
		else
		{
			return "No record found";
		}
	}

}
