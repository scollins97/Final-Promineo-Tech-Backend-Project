package com.promineo.pets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.pets.exception.ResourceNotFoundException;
import com.promineo.pets.model.ContactInfo;
import com.promineo.pets.repository.ContactInfoRepository;
import com.promineo.pets.service.ContactInfoService;

@Service
public class ContactInfoServiceImpl implements ContactInfoService{
	private ContactInfoRepository contactInfoRepository;
	@Autowired
	public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
		super();
		this.contactInfoRepository = contactInfoRepository;
	}

	@Override
	public ContactInfo saveContactInfo(ContactInfo contactInfo) {
		return contactInfoRepository.save(contactInfo);
	}
	@Override
	public List<ContactInfo> getAllContactInfo() {
		return contactInfoRepository.findAll();
	}

	@Override
	public ContactInfo getContactInfoById(int id) {
		return contactInfoRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Contact Info", "Id", id));
	}

	@Override
	public ContactInfo updateContactInfo(ContactInfo contactInfo, int id) {
		ContactInfo existingContactInfo = contactInfoRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Contact Info", "Id", id));
		existingContactInfo.setAddress(contactInfo.getAddress());
		existingContactInfo.setPhone(contactInfo.getPhone());
		existingContactInfo.setEmail(contactInfo.getEmail());
		
		return existingContactInfo;
	}

	@Override
	public void deleteContactInfo(int id) {
		ContactInfo existingContactInfo = contactInfoRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Contact Info", "Id", id));
		contactInfoRepository.deleteById(id);
	}
}
