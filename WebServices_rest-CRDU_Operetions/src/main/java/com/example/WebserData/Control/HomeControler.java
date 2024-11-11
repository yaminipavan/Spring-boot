package com.example.WebserData.Control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WebserData.Entity.Employee;
import com.example.WebserData.Repository.EmpRepository;

@RestController
@RequestMapping("/Employee")
public class HomeControler {

	
	@Autowired
	EmpRepository repository;
	
	@GetMapping("/get")
	public List<Employee> getdata() {
		List<Employee> employees = repository.findAll();
		return employees;
	}
	@PostMapping("/add")
	public Employee insert( @RequestBody Employee employee) {
		Employee emp = repository.save(employee);
		
		return emp;	
	}
	@GetMapping("/getbyid/{empid}")
	public Employee getelbyId(@PathVariable int empid) {
		    Employee employee = repository.findById(empid).get();
			return employee;
		    
	}
	@DeleteMapping("/delete/{empid}")
	public void delete(@PathVariable int empid) {
		Employee employee = repository.findById(empid).get();
		 repository.delete(employee);
	}
	
	@PutMapping("/update/{empid}")
	public Employee update(@PathVariable int empid,@RequestBody Employee employee) {
//		List<Employee> emp = repository.findAll();
		 employee.setEmpdep(employee.getEmpdep());
		 employee.setEmpname(employee.getEmpname());
		 repository.save(employee);
		 return employee;
		
	}
	
	
}
