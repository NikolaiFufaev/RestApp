package com.landmarkdataservice.repository;

import com.landmarkdataservice.entity.Landmark;
import com.landmarkdataservice.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LandmarkRepository extends JpaRepository<Landmark, Long> {


    List<Landmark> findAllByTypeOrderByName(Type type);


    List<Landmark> findAllByLocalityId(Long localityId);

}
