package com.landmarkdataservice.service.mapper;


import com.landmarkdataservice.entity.Landmark;
import com.landmarkdataservice.entity.Type;
import com.landmarkdataservice.repository.LocalityRepository;
import com.landmarkdataservice.service.dto.LandmarkDtoNew;
import com.landmarkdataservice.service.dto.LandmarkDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class LandmarkMapper {
    private final LocalityRepository localityRepository;
    private final LocalityMapper localityMapper;
    private final FavorMapper favorMapper;
@Autowired
    private LandmarkMapper(LocalityRepository localityRepository, LocalityMapper localityMapper, FavorMapper favorMapper) {
        this.localityRepository = localityRepository;
        this.localityMapper = localityMapper;
        this.favorMapper = favorMapper;
    }

    public Landmark toLandmarkFromDtoNew(LandmarkDtoNew landmarkDtoNew) {
        return Landmark.builder()
                .name(landmarkDtoNew.getName())
                .shortDescription(landmarkDtoNew.getShortDescription())
                .creationDate(LocalDate.now())
                .type(Type.valueOf(landmarkDtoNew.getType()))
                .locality(localityRepository.findLocalityById(landmarkDtoNew.getLocalityId()))
                .favors(favorMapper.toListFavorById(landmarkDtoNew.getFavors()))
                .build();
    }

    public LandmarkDtoOut toLandmarkDtoOut(Landmark landmark) {
        return LandmarkDtoOut.builder()
                .name(landmark.getName())
                .creationDate(landmark.getCreationDate())
                .shortDescription(landmark.getShortDescription())
                .locality(localityMapper.toLocalityDto(landmark.getLocality()))
                .type(landmark.getType().name())
                .favors(favorMapper.toListFavorDtoOut(landmark.getFavors()))
                .build();
    }

    public List<LandmarkDtoOut> toListLandmarkDtoOut(List<Landmark> landmarks) {
        List<LandmarkDtoOut> landmarkDtoOuts = new ArrayList<>();
        for (Landmark landmark : landmarks) {
            landmarkDtoOuts.add(toLandmarkDtoOut(landmark));
        }
        return landmarkDtoOuts;
    }
}
