package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Applicant;
import com.example.demo.Entity.Employer;
import com.example.demo.Repository.EmployerRepo;

@Service
public class EmployerService {
	@Autowired
	private EmployerRepo employerrepo;
	public void EmployerInfoSave(Employer employer) {
		employerrepo.save(employer);
	}
	public List<Employer>EmployerList(){
		return employerrepo.findAll();
	}
	public void Employerdelete(int eid) {
		
		employerrepo.deleteById(eid);
	}
	
}
