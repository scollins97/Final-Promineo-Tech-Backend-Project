package com.promineo.pets.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="ownership")
public class Ownership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int owner_id;
	
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private Gender gender;
	
//	@OneToMany(mappedBy = "ownership")
//	private List<ContactInfo> contactInfo;
	
//	@ManyToMany(mappedBy = "owner_pet")
//	private List<Pet> pet = new ArrayList<Pet>();
}
