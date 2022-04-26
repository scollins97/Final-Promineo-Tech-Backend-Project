package com.promineo.pets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="owner_pet")
public class Owner_Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pet_id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int owner_id;
}
