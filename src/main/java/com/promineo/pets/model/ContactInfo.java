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
@Table(name="contact_info")
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int owner_id;
	@Column
	private String address;
	@Column
	private String phone;
	@Column 
	private String email;
}
