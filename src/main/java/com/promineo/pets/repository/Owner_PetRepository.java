package com.promineo.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.pets.model.Owner_Pet;

@Repository
public interface Owner_PetRepository extends JpaRepository<Owner_Pet, Integer>{

}
