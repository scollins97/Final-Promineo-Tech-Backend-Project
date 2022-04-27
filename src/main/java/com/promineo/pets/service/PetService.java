package com.promineo.pets.service;
import java.util.List;

import com.promineo.pets.model.Pet;

public interface PetService {
	Pet savePet(Pet pet);

	List<Pet> getAllPets();
	
	Pet getPetById(int id);
	
	Pet updatePet(Pet pet, int id);
	
	void deletePet(int id);
}
