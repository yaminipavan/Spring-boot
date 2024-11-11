package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer AddressID;
	
	private Integer empid;
	private String vlg;
	private String city;
	private String state;
	private Integer pincode;
}
