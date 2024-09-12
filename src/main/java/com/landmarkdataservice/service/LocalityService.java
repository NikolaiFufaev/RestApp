package com.landmarkdataservice.service;

import com.landmarkdataservice.entity.Locality;
import com.landmarkdataservice.exeption.ObjectNotFoundException;
import com.landmarkdataservice.exeption.RejectedRequestException;
import com.landmarkdataservice.repository.LocalityRepository;
import com.landmarkdataservice.service.dto.LocalityDtoNew;
import com.landmarkdataservice.service.dto.LocalityDtoOut;
import com.landmarkdataservice.service.mapper.LocalityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LocalityService {
    private final LocalityRepository localityRepository;
    private final LocalityMapper localityMapper;

    @Autowired
    public LocalityService(LocalityRepository localityRepository, LocalityMapper localityMapper) {
        this.localityRepository = localityRepository;
        this.localityMapper = localityMapper;
    }

    public void createLocality(LocalityDtoNew dtoNew) {
        localityMapper.toLocalityDto(localityRepository.save(localityMapper.toLocalityFromNewDto(dtoNew)));
    }

    @Transactional
    public LocalityDtoOut updateLocalityById(Long localityId, Boolean metro, Long population) {
        Locality locality = localityRepository
                .findById(localityId)
                .orElseThrow(() -> new ObjectNotFoundException("Locality not found"));
        if (metro == null && population == null) {
            throw new RejectedRequestException("Incorrect data for update ");
        }
        if (metro != null && locality.getMetro() != metro) {
            locality.setMetro(metro);
        }
        if (population != null && !locality.getPopulation().equals(population)) {
            locality.setPopulation(population);
        }
        return localityMapper.toLocalityDto(localityRepository.save(locality));
    }

}
