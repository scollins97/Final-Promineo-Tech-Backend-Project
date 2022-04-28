package com.promineo.pets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.pets.model.ContactInfo;
import com.promineo.pets.service.ContactInfoService;

@RestController
@RequestMapping("/pet_db/contact_info")
public class ContactInfoController {

	private ContactInfoService contactInfoService;
	
	public ContactInfoController(ContactInfoService contactInfoService) {
		super();
		this.contactInfoService = contactInfoService;
	}
	
	@PostMapping()
	public ResponseEntity<ContactInfo> saveContactInfo(
			@RequestBody ContactInfo contactInfo) {
		return new ResponseEntity<ContactInfo>(
				contactInfoService.saveContactInfo(contactInfo), HttpStatus.CREATED);
	}
	@GetMapping List<ContactInfo> getAllContactInfo() {
		return contactInfoService.getAllContactInfo();
	}
	@GetMapping("{contact_id}")
	public ResponseEntity<ContactInfo> getContactInfoById(
			@PathVariable("owner_id") int contactId){
		return new ResponseEntity<ContactInfo>(
				contactInfoService.getContactInfoById(contactId),HttpStatus.OK);
	}
	@PutMapping("{contact_id}")
	public ResponseEntity<ContactInfo> updateContactInfo(
			@PathVariable("owner_id") int contactId, @RequestBody ContactInfo contactInfo) {
		return new ResponseEntity<ContactInfo>(
				contactInfoService.updateContactInfo(contactInfo, contactId), HttpStatus.OK);
	}
	@DeleteMapping("{contact_id}")
	public ResponseEntity<String> deleteContactInfo(@PathVariable("owner_id") int contactId){
		contactInfoService.deleteContactInfo(contactId);
		
		return new ResponseEntity<String>("Contact Info Deleted!!", HttpStatus.OK);
	}
}
