package com.promineo.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.pets.model.Ownership;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership, Integer> {

}
