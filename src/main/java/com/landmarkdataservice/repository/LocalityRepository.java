package com.landmarkdataservice.repository;


import com.landmarkdataservice.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocalityRepository extends JpaRepository<Locality, Long> {

    Locality findLocalityById(Long id);
}
