package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Lob
	private byte[]cvImage;
	
	
	
	public Cv(byte[] cvImage) {
		super();
		this.cvImage = cvImage;
	}
	
	public Cv() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getCvImage() {
		return cvImage;
	}
	public void setCvImage(byte[] cvImage) {
		this.cvImage = cvImage;
	}
	
}
