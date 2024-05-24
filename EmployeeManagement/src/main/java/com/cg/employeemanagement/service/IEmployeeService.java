package com.cg.employeemanagement.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cg.employeemanagement.entity.Employee;

public interface IEmployeeService {
	List<Employee> findAllEmployee();
	Optional<Employee> findById(Long id);
	Employee saveEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(Long id);
	//	Employee updateEmployeeBySalary(Long id, Employee employee );
	Employee updateEmployeeBySalary(Long id, Map<String, Object> map);
}
