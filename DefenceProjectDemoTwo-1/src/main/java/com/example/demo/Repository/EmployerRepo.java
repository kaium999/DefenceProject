package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Employer;

public interface EmployerRepo extends JpaRepository<Employer, Integer>{
	public boolean existsByEmail(String email);
	public Employer findByEmail(String email);
	public boolean existsByPassword(String password);
}
