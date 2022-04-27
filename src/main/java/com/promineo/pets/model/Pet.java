package com.promineo.pets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
@Entity
@Table(name="player")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pet_id;
	@Column
	private String pet_name;
	@Column
	private PetCatOrDog cat_or_dog;
	@Column
	private String DOB;
	@Column
	private String breed;
	@Column
	private String color;
	@Column
	private Gender gender;
}
