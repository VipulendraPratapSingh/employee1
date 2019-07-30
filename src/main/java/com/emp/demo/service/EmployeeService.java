package com.emp.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.emp.demo.entity.Employee;
import com.emp.demo.exception.EmployeeNotFoundException;

@Service
public interface EmployeeService {
	public String addEmployee(Employee employee)throws EmployeeNotFoundException;
	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException;
	public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee)throws EmployeeNotFoundException;
	public List<Employee> getAllEmployee()throws EmployeeNotFoundException;
	public String delete(Long id) throws EmployeeNotFoundException;
}
