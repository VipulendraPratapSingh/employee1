package com.emp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.demo.entity.Employee;
import com.emp.demo.exception.EmployeeNotFoundException;
import com.emp.demo.service.Impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {

		return employeeServiceImpl.addEmployee(employee);
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
		return employeeServiceImpl.getEmployeeById(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee)
			throws EmployeeNotFoundException {
		return employeeServiceImpl.updateEmployee(id, employee);
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee()throws EmployeeNotFoundException {
		return employeeServiceImpl.getAllEmployee();
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String delete(@PathVariable("id") Long id)throws EmployeeNotFoundException {
		return employeeServiceImpl.delete(id);
	}

}
