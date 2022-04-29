package com.promineo.pets.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.pets.exception.ResourceNotFoundException;
import com.promineo.pets.model.Ownership;
import com.promineo.pets.model.Pet;
import com.promineo.pets.repository.OwnershipRepository;
import com.promineo.pets.service.OwnershipService;

@Service
public class OwnershipServiceImpl implements OwnershipService{
	private OwnershipRepository ownershipRespository;
	@Autowired
	public OwnershipServiceImpl(OwnershipRepository ownershipRepository) {
		super();
		this.ownershipRespository=ownershipRepository;
	}
	@Override
	public Ownership saveOwnership(Ownership ownership) {
		return ownershipRespository.save(ownership);
	}
	@Override
	public List<Ownership> getAllOwners(){
		return ownershipRespository.findAll();
	}
	@Override
	public Ownership getOwnerById(int id) {
		return ownershipRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ownership", "Id", id));
	}
	@Override
	public Ownership updateOwnership(Ownership owner, int id) {
		Ownership existingOwner = ownershipRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ownership", "Id", id));
		existingOwner.setFirst_name(owner.getFirst_name());
		existingOwner.setLast_name(owner.getLast_name());
		existingOwner.setGender(owner.getGender());
		
		ownershipRespository.save(existingOwner);
		
		return existingOwner;
	}
	@Override
	public void deleteOwnership(int id) {
		Ownership existingOwner = ownershipRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ownership", "Id", id));
		ownershipRespository.deleteById(id);
	}
	@Override
	public List<Pet> getAllPetsPerOwnerId(int id) {
		Ownership existingOwner = ownershipRespository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ownership", "Id", id));
		Set<Pet> ownersPetsSet = existingOwner.getPetsByOwnerId();
		return new ArrayList<>(ownersPetsSet);
	}
}
