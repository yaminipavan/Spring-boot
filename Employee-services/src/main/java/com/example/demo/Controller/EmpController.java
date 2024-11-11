package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.Entity.Employee1;
import com.example.demo.Repository.EmpRepository;
import com.example.demo.clint.AddressClint;

@RestController
@RequestMapping("/Employee-service")
public class EmpController {
	
	@Autowired
	private EmpRepository empRepository;
	
	@Autowired
	private AddressClint addressClint;

	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		Employee1 saveEmployee = empRepository.save(employeeDTO.getEmployee1());
		
		if(saveEmployee != null && saveEmployee.getEmpid()>0) {
			addressClint.saveAddress(employeeDTO.getAddress1(), saveEmployee.getEmpid());
		}
		
		return new ResponseEntity<>("Employee "+saveEmployee.getEmpname()+"saved successfully with id "+saveEmployee.getEmpid(),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee1>> getEmployee(){
		List<Employee1> saveEmployee = empRepository.findAll();
		
		return new ResponseEntity<> (saveEmployee,HttpStatus.CREATED);
	}
}
