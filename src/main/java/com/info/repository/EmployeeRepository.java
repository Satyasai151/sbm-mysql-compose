package com.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
