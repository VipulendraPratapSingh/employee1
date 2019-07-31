package com.emp.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.emp.demo.entity.Employee;
import com.emp.demo.exception.EmployeeNotFoundException;
import com.emp.demo.repository.EmployeeRepository;
import com.emp.demo.service.Impl.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

@Mock
EmployeeRepository employeeRepository;

@InjectMocks
EmployeeServiceImpl employeeServiceImpl;

	/*
	 * @Test public void testAddEmployee() throws EmployeeNotFoundException {
	 * Employee emp = new Employee(); emp.setEmpName("vikash");
	 * emp.setProfile("hr"); emp.setSalary(3000.0);
	 * 
	 * Mockito.when(employeeRepository.save(emp)).thenReturn(emp); String
	 * atualValues = employeeServiceImpl.addEmployee(emp);
	 * Assert.assertEquals(atualValues, "successfully saved");
	 * 
	 * }
	 */

	/*
	 * @Test public void testgetByIdEmployee() throws EmployeeNotFoundException{
	 * Employee employee = new Employee(); employee.setEmpid(3L);
	 * employee.setEmpName("ajay"); employee.setProfile("trainer");
	 * employee.setSalary(4099.0);
	 * Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(
	 * Optional.of(employee)); Employee actualValues=
	 * employeeServiceImpl.getEmployeeById(employee.getEmpid());
	 * Assert.assertEquals(actualValues, employee); }
	 */

	/*
	 * @Test public void testgetAllEmployee() throws EmployeeNotFoundException {
	 * Employee employee1 = new Employee(); employee1.setEmpid(4L);
	 * employee1.setEmpName("ajay"); employee1.setProfile("HR");
	 * employee1.setSalary(4099.0);
	 * 
	 * Employee employee2 = new Employee(); employee2.setEmpid(5L);
	 * employee2.setEmpName("ajay1"); employee2.setProfile("trainer");
	 * employee2.setSalary(4099.0);
	 * 
	 * List<Employee> list = new ArrayList<>(); list.add(employee1);
	 * list.add(employee2);
	 * 
	 * Mockito.when(employeeRepository.findAll()).thenReturn(list); List<Employee>
	 * listofemployee = employeeServiceImpl.getAllEmployee();
	 * Assert.assertEquals(list, listofemployee); }
	 */
@Test
public void testUpdateEmployee()throws EmployeeNotFoundException {
	Employee employee2 = new Employee();
	employee2.setEmpid(3L);
	employee2.setEmpName("ajay3");
	employee2.setProfile("account");
	employee2.setSalary(3099.0);
	Mockito.when(employeeRepository.save(employee2)).thenReturn(employee2);
	String actualValues = employeeServiceImpl.updateEmployee(3L, employee2);
    Assert.assertEquals("updated Successfully", actualValues);
}
}
