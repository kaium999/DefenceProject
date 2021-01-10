package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Circular {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String circularname;
	private LocalDateTime starttime;
	private LocalDateTime endtime;
	private String url;
	@OneToMany(mappedBy = "circular")
	private List<Applicant>Applicants=new ArrayList<>();
	@ManyToOne
	private Employer employer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCircularname() {
		return circularname;
	}
	public void setCircularname(String circularname) {
		this.circularname = circularname;
	}
	public LocalDateTime getStarttime() {
		return starttime;
	}
	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}
	public LocalDateTime getEndtime() {
		return endtime;
	}
	public void setEndtime(LocalDateTime endtime) {
		this.endtime = endtime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Applicant> getApplicants() {
		return Applicants;
	}
	public void setApplicants(List<Applicant> applicants) {
		Applicants = applicants;
	}
	
}
