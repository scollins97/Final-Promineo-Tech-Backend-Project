package com.promineo.pets.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
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
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToMany(mappedBy = "ownership") //either this or owner_id
	@JsonIgnore
	private Set<ContactInfo> contactInfo;
	
	@ManyToMany
	@JoinTable(
	  name = "owner_pet", 
	  joinColumns = @JoinColumn(name = "owner_id"), 
	  inverseJoinColumns = @JoinColumn(name = "pet_id"))
	@JsonIgnore
	private Set<Pet> petsByOwnerId;
}
