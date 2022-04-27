package com.promineo.pets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineo.pets.exception.ResourceNotFoundException;
import com.promineo.pets.model.Pet;
import com.promineo.pets.repository.PetRepository;
import com.promineo.pets.service.PetService;

@Service
public class PetServiceImpl implements PetService{
	private PetRepository petRepository;
	@Autowired
	public PetServiceImpl(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}
	@Override
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}
	@Override
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}
	@Override
	public Pet getPetById(int id) {
		return petRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", id));
	}
	@Override
	public Pet updatePet(Pet pet, int id) {
		Pet existingPet = petRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", id));
		existingPet.setPet_name(pet.getPet_name());
		existingPet.setCat_or_dog(pet.getCat_or_dog());
		existingPet.setDOB(pet.getDOB());
		existingPet.setBreed(pet.getBreed());
		existingPet.setColor(pet.getColor());
		existingPet.setGender(pet.getGender());
		
		return existingPet;
	}
	@Override
	public void deletePet(int id) {
		Pet existingPet = petRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", id));
		petRepository.deleteById(id);
	}

}
