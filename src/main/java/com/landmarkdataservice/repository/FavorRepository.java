package com.landmarkdataservice.repository;


import com.landmarkdataservice.entity.Favor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FavorRepository extends JpaRepository<Favor, Long> {
}
