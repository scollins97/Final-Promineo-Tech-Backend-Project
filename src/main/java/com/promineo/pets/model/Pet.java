package com.promineo.pets.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name="pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pet_id;
	
	@Column
	private String pet_name;
	@Column
	@Enumerated(EnumType.STRING)
	private PetCatOrDog cat_or_dog;
	@Column
	private String DOB;
	@Column
	private String breed;
	@Column
	private String color;
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToMany(mappedBy = "petsByOwnerId")
	@JsonIgnore
	private Set<Ownership> owners;
}
