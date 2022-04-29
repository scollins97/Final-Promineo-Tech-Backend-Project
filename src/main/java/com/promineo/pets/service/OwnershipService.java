package com.promineo.pets.service;

import java.util.List;
import com.promineo.pets.model.Ownership;
import com.promineo.pets.model.Pet;

public interface OwnershipService {
	Ownership saveOwnership(Ownership ownership);

	List<Ownership> getAllOwners();
	
	Ownership getOwnerById(int id);
	
	Ownership updateOwnership(Ownership owner, int id);
	
	void deleteOwnership(int id);
	
	List<Pet> getAllPetsPerOwnerId(int id);
}
