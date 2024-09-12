package com.landmarkdataservice.service;

import com.landmarkdataservice.entity.Landmark;
import com.landmarkdataservice.entity.Type;
import com.landmarkdataservice.exeption.ObjectNotFoundException;
import com.landmarkdataservice.repository.LandmarkRepository;
import com.landmarkdataservice.repository.LocalityRepository;
import com.landmarkdataservice.service.dto.LandmarkDtoNew;
import com.landmarkdataservice.service.dto.LandmarkDtoOut;
import com.landmarkdataservice.service.mapper.LandmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LandmarkService {
    private final LandmarkRepository landmarkRepository;
    private final LocalityRepository localityRepository;
    private final LandmarkMapper landmarkMapper;

    @Autowired
    public LandmarkService(LandmarkRepository landmarkRepository, LocalityRepository localityRepository, LandmarkMapper landmarkMapper) {
        this.landmarkRepository = landmarkRepository;
        this.localityRepository = localityRepository;
        this.landmarkMapper = landmarkMapper;
    }

    @Transactional
    public void createLandmark(LandmarkDtoNew dtoNew) {
        if (localityRepository.existsById(dtoNew.getLocalityId())) {
            if (Type.contains(dtoNew.getType())) {
                Landmark landmark = landmarkMapper.toLandmarkFromDtoNew(dtoNew);
                landmarkRepository.save(landmark);
            } else {
                throw new ObjectNotFoundException("Landmark type not found");
            }
        } else {
            throw new ObjectNotFoundException("City not exists");
        }


    }

    public List<LandmarkDtoOut> getAllLandmarkByTypeAndSortByName(String type) {
        if (Type.contains(type)) {
            Type type1 = Type.valueOf(type);
            List<Landmark> landmarks = landmarkRepository.findAllByTypeOrderByName(type1);
            return landmarkMapper.toListLandmarkDtoOut(landmarks);
        }
        throw new ObjectNotFoundException("Landmark type not found");
    }


    public List<LandmarkDtoOut> getAllLandmarkByLocalityId(Long localityId) {
         List<Landmark> landmarks =  landmarkRepository.findAllByLocalityId(localityId);
        return landmarkMapper.toListLandmarkDtoOut(landmarks);
    }

    @Transactional
    public LandmarkDtoOut updateLandmark(Long landmarkId, String description) {
        Landmark landmark = landmarkRepository
                .findById(landmarkId)
                .orElseThrow(() -> new ObjectNotFoundException("landmark not found"));
        landmark.setShortDescription(description);
        return landmarkMapper.toLandmarkDtoOut(landmarkRepository.save(landmark));
    }

    public void deleteLandmarkById(Long landmarkId) {
        if (landmarkRepository.existsById(landmarkId)){
            landmarkRepository.deleteById(landmarkId);
        } else {throw new ObjectNotFoundException("landmark not found");}

    }


}
