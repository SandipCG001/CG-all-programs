package com.cg.employeemanagement.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils.FieldFilter;

import com.cg.employeemanagement.entity.Employee;
import com.cg.employeemanagement.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployeeBySalary(Long id, Map<String, Object> map) {
		Optional<Employee> employee= employeeRepository.findById(id);
		map.forEach((key, value) ->{
		 Field field= ReflectionUtils.findRequiredField(Employee.class, key);
		 field.setAccessible(true);
		 ReflectionUtils.setField(field, employee, value);
		});
		
		
		return employeeRepository.save(employee);
	}

	
	
	
//	@Override
//	public Employee updateEmployeeBySalary(Long id, Map<String, Optional> map) {
//		
//		Employee employee= employeeRepository.findById(id).get();
//		for(Map.Entry<String, Optional> hm :map.entrySet()) {
//			
//			String keyFromMap= hm.getKey();
//			
//			if(keyFromMap.equals("name")) {
//				Optional<Object> na= hm.getValue();
//				String value =na.map(Object::toString).orElse(null);
//				employee.setName(value);
//			}
//			
//			if(keyFromMap.equals("salary")) {
//				Optional<Double> sal= hm.getValue();
//				Double value= Double.valueOf(sal.get());
//				employee.setSalary(value);
//				
//			}
//		}
//		
//		return employeeRepository.save(employee);
//		
//	}
	
	
	
	
}
