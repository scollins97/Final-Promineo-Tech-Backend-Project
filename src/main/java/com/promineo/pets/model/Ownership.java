package com.promineo.pets.model;

import lombok.Data;

@Data
public class Ownership {
	private int owner_id;
	private String first_name;
	private String last_name;
	private OwnershipGender gender;
}
