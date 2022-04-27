package com.promineo.pets.service;

import java.util.List;

import com.promineo.pets.model.ContactInfo;

public interface ContactInfoService {
	ContactInfo saveContactInfo(ContactInfo contactInfo);

	List<ContactInfo> getAllContactInfo();
	
	ContactInfo getContactInfoById(int id);
	
	ContactInfo updateContactInfo(ContactInfo contactInfo, int id);
	
	void deleteContactInfo(int id);
}
