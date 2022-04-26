package com.promineo.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineo.pets.model.ContactInfo;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Integer>{

}
