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
}
