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
import com.promineo.pets.model.Ownership;
import com.promineo.pets.model.Pet;
import com.promineo.pets.service.OwnershipService;

@RestController
@RequestMapping("/pets_db/ownership")
public class OwnershipController {
	
	private OwnershipService ownershipService;
	
	public OwnershipController(OwnershipService ownershipService) {
		super();
		this.ownershipService = ownershipService;
	}
	
	@PostMapping()
	public ResponseEntity<Ownership> saveOwnership(@RequestBody Ownership ownership){
		return new ResponseEntity<Ownership>(
				ownershipService.saveOwnership(ownership), HttpStatus.CREATED);
	}
	@GetMapping
	public List<Ownership> getAllOwners(){
		return ownershipService.getAllOwners();
	}
	@GetMapping("{owner_id}")
	public ResponseEntity<Ownership> getOwnerById(@PathVariable("owner_id") int ownerId){
		return new ResponseEntity<Ownership>(ownershipService.getOwnerById(ownerId),
				HttpStatus.OK);
	}
	@PutMapping("{owner_id}")
	public ResponseEntity<Ownership> updateOwnership(@PathVariable("owner_id") int ownerId,
			@RequestBody Ownership owner){
		return new ResponseEntity<Ownership>(ownershipService
				.updateOwnership(owner, ownerId), HttpStatus.OK);
	}
	@DeleteMapping("{owner_id}")
	public ResponseEntity<String> deleteOwnership(@PathVariable("owner_id") int ownerId){
		ownershipService.deleteOwnership(ownerId);
		return new ResponseEntity<String>("Owner Deleted!!", HttpStatus.OK);
	}
	@GetMapping("ownership/{owner_id}/pet")
	public List<Pet> getAllPetsPerOwnerId(@PathVariable("owner_id") int ownerId){
		return ownershipService.getAllPetsPerOwnerId(ownerId);
	}
}
