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
import com.promineo.pets.model.Pet;
import com.promineo.pets.service.PetService;

@RestController
@RequestMapping("/pets_db/pet")
public class PetController {
	
	private PetService petService;
	
	public PetController(PetService petService) {
		super();
		this.petService = petService;
	}
	
	@PostMapping()
	//Post
	public ResponseEntity<Pet> savePet(@RequestBody Pet pet) {
		return new ResponseEntity<Pet>(petService.savePet(pet), HttpStatus.CREATED);
	}
	@GetMapping
	//Get all the pets
	public List<Pet> getAllPets() {
		return petService.getAllPets();
	}
	@GetMapping("{pet_id}")
	//Get one pet by it's ID
	public ResponseEntity<Pet> getPetById(@PathVariable("pet_id") int petId){
		return new ResponseEntity<Pet>(petService.getPetById(petId), 
				HttpStatus.OK);
	}
	@PutMapping("{pet_id}")
	//Put -- update pet
	public ResponseEntity<Pet> updatePet(
			@PathVariable("pet_id") int petId, @RequestBody Pet pet){
		return new ResponseEntity<Pet>(petService.updatePet(pet, petId), 
				HttpStatus.OK);
	}
	@DeleteMapping("{pet_id}")
	//Destroy the pet
	public ResponseEntity<String> deletePet(@PathVariable("pet_id") int petId){
		petService.deletePet(petId);
		
		return new ResponseEntity<String>("Pet Deleted!!", HttpStatus.OK);
	}
}
