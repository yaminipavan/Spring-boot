package com.example.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empid;
	
	private String empname;
	private Integer empsalary;
	
}
