package com.emp.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.demo.entity.Employee;
import com.emp.demo.exception.EmployeeNotFoundException;
import com.emp.demo.service.Impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/restApi")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employee2= employeeServiceImpl.addEmployee(employee);
		 return  new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	} 

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
		Employee employee = employeeServiceImpl.getEmployeeById(id);
		 return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee)
			throws EmployeeNotFoundException {
		   String string = employeeServiceImpl.updateEmployee(id, employee);
		   return new ResponseEntity<String>(string, HttpStatus.OK);
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee()throws EmployeeNotFoundException {
		List<Employee> employeeList = employeeServiceImpl.getAllEmployee();
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id)throws EmployeeNotFoundException {
		String str = employeeServiceImpl.delete(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}

}
