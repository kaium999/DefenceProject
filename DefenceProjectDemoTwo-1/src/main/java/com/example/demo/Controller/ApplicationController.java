package com.example.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Applicant;
import com.example.demo.Entity.Cv;

import com.example.demo.Entity.Employer;


import com.example.demo.Entity.ProfilePicture;
import com.example.demo.Repository.ApplicantRepository;
import com.example.demo.Repository.EmployerRepo;
import com.example.demo.Service.ApplicantService;
import com.example.demo.Service.EmployerService;



@Controller
public class ApplicationController {
	@Autowired
	Employer employer;
	@Autowired
	private ApplicantService ApplicantService;
	@Autowired
	private EmployerService Employerservice;
	@Autowired
	private EmployerRepo emrepo;
	@Autowired
	private ApplicantRepository applirepo;
	@Autowired
	private ProfilePicture picture;
	@RequestMapping("/")
	public String ApplicantPage() {
		return"ApplicantPage.html";
	}
	

	
	@RequestMapping(value = "/saveApp", method = RequestMethod.POST)
	public String SaveApplicantInfo(Applicant applicant) {
		//System.out.println(applicant.getName());
		//System.out.println(applicant.getAddress());
	
		//Applicant applicantone=new Applicant();
		//System.out.println(cv.getCvImage());
		//applicantone.setCv(cv);
		
		//System.out.print(image);
		 
		
		
		 
		//applicant.setProfilePicture(picture);
		
		//applicant.setProfilePicture(picture);
		
		ApplicantService.AppliInfoSave(applicant);
		return"Save.html";
	}
	@RequestMapping("/showapplicant")
	public String applicantListPage(Model model) {
		List<Applicant>applicantList=ApplicantService.applicantList();
		model.addAttribute("applicantList",applicantList);
		return "showapplicant.html";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView ShowProductEditPage(@PathVariable(name = "id") int id) {
		ModelAndView mv=new ModelAndView("applicanteditpage.html");
		Applicant applicant=ApplicantService.getApplicant(id);
		mv.addObject("applicant", applicant);
		return mv;
	}
	@RequestMapping("/update")
	public String Update(Applicant applicant) {
		//System.out.println(applicant.getName());
		applirepo.save(applicant);
	
		return "bal.html";
	}
	
	/*
	@RequestMapping("/delete/{id}")
	public String deleteapplicant(@PathVariable(name = "id") int id) {
	    ApplicantService.Applicantdelete(id);
	    return "redirect:/";       
	}*/
	@RequestMapping(value = "/saveEpp", method = RequestMethod.POST)
	public String SaveEmployerInfo(Employer employer) {
	
		Employerservice.EmployerInfoSave(employer);
		return"Save.html";
		
	}
	@RequestMapping("/showemployerlist")
	public String EmployerList(Model model) {
		List<Employer>employerList=Employerservice.EmployerList();
		model.addAttribute("employerList",employerList);
		return "showemployerlist.html";
	}
	@RequestMapping("/delete/{eid}")
	public String deleteEmployer(@PathVariable(name = "eid") int eid) {
	    Employerservice.Employerdelete(eid);
	    return "Save.html";       
	}
	@RequestMapping("/login")
	public String UserLogIn(Employer employeer) {
		System.out.println(employeer.getEmail());
		System.out.println(employeer.getPassword());
		//boolean oyshe=emrepo.existsByEmail(employer.getEmail());
		//boolean pass=emrepo.existsByPassword(employer.getPassword());
		//System.out.println(oyshe);
		if(emrepo.existsByEmail(employeer.getEmail())) {
			employer=emrepo.findByEmail(employeer.getEmail());
			if(employeer.getPassword().equals(employer.getPassword())) {
			
				System.out.println("successfully log in");
			}else if(employeer.getPassword()!=employer.getPassword()) {
				System.out.println(employeer.getPassword());
				System.out.println("log in failed>>>>>");
			}
			
			return"Sucessfullogin.html";
		}else {
			System.out.println("You are not registered");
			return"employerlogin.html";
		}
		
		//if(employer.getEmail())
		
		//return"employerlogin.html";
	}
	
	
	
}
