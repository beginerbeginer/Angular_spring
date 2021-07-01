package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Operation(summary = "従業員を全権取得します")
	@GetMapping("/employees")
	public List<Employee> getAllEmloyees() {
		return employeeRepository.findAll();
	}
}
