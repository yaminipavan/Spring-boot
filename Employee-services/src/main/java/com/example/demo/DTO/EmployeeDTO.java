package com.example.demo.DTO;

import java.util.List;

import com.example.demo.Entity.Address1;
import com.example.demo.Entity.Employee1;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Employee1 employee1;
	private List<Address1> address1;
	
}
