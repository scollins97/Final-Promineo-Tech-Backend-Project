package com.promineo.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.pets.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{

}
