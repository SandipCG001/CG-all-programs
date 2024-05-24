package com.cg.employeemanagement.controller;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeemanagement.entity.Employee;
import com.cg.employeemanagement.service.IEmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;

	
	@GetMapping
	public List<Employee> findAllEmployee() {
		return employeeService.findAllEmployee();
	}
	@GetMapping("/{id}")
	public Optional<Employee> findEmployeeById(@PathVariable(value = "id") Long id){
		return employeeService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee ) {
		 employeeService.saveEmployee(employee);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping
	public void deleteEmployee(@PathVariable(value = "id") Long id) {
		employeeService.deleteEmployee(id);
	}
	
	//Requestparam
	@GetMapping("/reqparam")
	public Optional<Employee> getEmployeeById(@RequestParam(value = "id") Long id){
		return employeeService.findById(id);
	}
	
	@PatchMapping("/updatesalary/{id}")
	public Employee updateEmployeeBySalary(@PathVariable Long id, @RequestBody Map<String, Object>  employee) {
		return employeeService.updateEmployeeBySalary(id,employee);
	}
	

}
