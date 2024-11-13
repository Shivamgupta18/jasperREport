package com.jasper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jasper.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
