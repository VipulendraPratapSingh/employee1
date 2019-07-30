package com.emp.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.demo.entity.Employee;
import com.emp.demo.exception.EmployeeNotFoundException;
import com.emp.demo.repository.EmployeeRepository;
import com.emp.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeReposotory;

	@Override
	public String addEmployee(Employee employee) {
		employeeReposotory.save(employee);
		return "successfully saved";
	}

	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
		if (id == null || id <= 0) {
			throw new EmployeeNotFoundException("*****Employee Not Found******");
		} else {
			return employeeReposotory.findById(id).get();
		}

	}

	public String updateEmployee(Long id, Employee employee) throws EmployeeNotFoundException {
		// Employee empExisting = employeeReposotory.findById(id).get();

		if (id == null || id <= 0) {
			throw new EmployeeNotFoundException("id is not found for updateEmployee");
		}
		Employee empExisting = getEmployeeById(id);
		empExisting.setEmpName(employee.getEmpName());
		empExisting.setProfile(employee.getProfile());
		empExisting.setSalary(employee.getSalary());
		employeeReposotory.save(empExisting);
		return "updated Successfully";
	}

	public List<Employee> getAllEmployee()throws EmployeeNotFoundException {
		return employeeReposotory.findAll();
	}
		  
	public String delete(Long id) throws EmployeeNotFoundException {
		Employee emp = getEmployeeById(id);
		employeeReposotory.delete(emp);
		return"delete successfully";
	}
}
