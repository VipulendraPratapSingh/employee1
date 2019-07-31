package com.emp.demo.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.emp.demo.controller.EmployeeController;
import com.emp.demo.entity.Employee;
import com.emp.demo.exception.EmployeeNotFoundException;
import com.emp.demo.service.Impl.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

@InjectMocks
private EmployeeController employeeController;

private MockMvc mockmvc;

@Mock
EmployeeServiceImpl employeeServiceImpl;

Employee employee; 
List<Employee>  list ;
@Before
public void setUp() throws EmployeeNotFoundException {
	MockMvcBuilders.standaloneSetup(employeeController).build();
	
 Employee employee = new Employee();
employee.setEmpid(7L);
employee.setEmpName("vikash");
employee.setProfile("hr");
employee.setSalary(10000.0);
 Employee employee1 = new Employee();
employee1.setEmpid(7L);
employee1.setEmpName("vikash");
employee1.setProfile("hr");
employee1.setSalary(10000.0);

list = new ArrayList<>();
list.add(employee1);
list.add(employee);

}

@Test
public void getAllEmployee()throws Exception {
	Mockito.when(employeeServiceImpl.getAllEmployee()).thenReturn(list);
	mockmvc.perform(MockMvcRequestBuilders.get("/restApi/getAllEmployee").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL).content(asJsonString(employee))).andExpect(status().isOk());
ResponseEntity<List<Employee>>	emplist = employeeController.getAllEmployee();
assertEquals(2, emplist.getBody().size());

}

private byte[] asJsonString(Employee employee2) {
	// TODO Auto-generated method stub
	return null;
}
}
