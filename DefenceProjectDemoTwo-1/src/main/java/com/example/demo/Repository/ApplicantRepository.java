package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
	
}
