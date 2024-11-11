package com.example.WebserData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebserData.Entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
