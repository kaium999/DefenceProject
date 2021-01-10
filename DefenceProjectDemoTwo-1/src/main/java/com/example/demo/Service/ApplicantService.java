package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Applicant;


import com.example.demo.Repository.ApplicantRepository;

@Service
public class ApplicantService {
	@Autowired
	private ApplicantRepository ApplicantRepo;
	
	
	public void AppliInfoSave(Applicant applicant) {
		ApplicantRepo.save(applicant);
	}
	public List<Applicant>applicantList(){
		return ApplicantRepo.findAll();
	}
	public void Applicantdelete(int id) {
		ApplicantRepo.deleteById(id);
	}
	public Applicant getApplicant(int id) {
		return ApplicantRepo.findById(id).get();
	}

}
