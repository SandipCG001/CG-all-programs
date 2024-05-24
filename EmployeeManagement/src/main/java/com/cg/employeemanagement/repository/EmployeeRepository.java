package com.cg.employeemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.employeemanagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	Employee save(Optional<Employee> employee);

}
