package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Operation(summary = "従業員を全権取得します")
	@GetMapping("/employees")
	public List<Employee> getAllEmloyees() {
		return employeeRepository.findAll();
	}

	@Operation(summary = "従業員を作成します")
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@Operation(summary = "従業員の詳細を取得します")
	@PostMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("従業員が見つかりません id: " + id));
		return ResponseEntity.ok(employee);
	}

	@Operation(summary = "従業員の情報を更新します")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("従業員が見つかりません id: " + id));

		employee.setFirstName(employeeDetails.getFirstName());
		employee.setFirstName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getEmailId());

		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}

	@Operation(summary = "従業員の情報を削除します")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("従業員が見つかりません id: " + id));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		// 返り値とメソッドの型は一致する必要がある（ResponseEntity）
		return ResponseEntity.ok(response);

	}
}
