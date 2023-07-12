package com.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.entity.Employee;
import com.info.exception.ResourseNotFoundException;
import com.info.repository.EmployeeRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		return employeeRepository.save(employee);

	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return employeeRepository.findAll();

	}
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee emp = employeeRepository.findById(id)
		.orElseThrow(()->new ResourseNotFoundException("emp not exit with id:"+id));
		return ResponseEntity.ok(emp);
		
	}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee empDetails){
		Employee updateEmployee = employeeRepository.findById(id)
		.orElseThrow(()-> new ResourseNotFoundException("emp not exit with id:"+id));
		updateEmployee.setFirstName(empDetails.getFirstName());
		updateEmployee.setLastName(empDetails.getLastName());
		updateEmployee.setEmail(empDetails.getEmail());
		employeeRepository.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);
		
	}

}
