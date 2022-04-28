package com.promineo.pets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="contact_info")
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contact_id;
	
	@Column
	private int owner_id;
	@Column
	private String address;
	@Column
	private String phone;
	@Column
	private String email;
	
//	@ManyToOne
//	@JoinColumn(name = "owner_id")
//	private Ownership ownership;
}
