package com.example.WebserData.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empid;
	private String empname,empdep;
	
	
	public Employee(String empname, String empdep) {
		super();
		this.empname = empname;
		this.empdep = empdep;
	}
	
	public Employee() {
		super();
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpdep() {
		return empdep;
	}
	public void setEmpdep(String empdep) {
		this.empdep = empdep;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empdep=" + empdep + "]";
	}
	
	
}
