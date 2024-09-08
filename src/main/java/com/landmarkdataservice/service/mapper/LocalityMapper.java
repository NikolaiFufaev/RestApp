package com.landmarkdataservice.service.mapper;


import com.landmarkdataservice.entity.Locality;
import com.landmarkdataservice.service.dto.LocalityDtoNew;
import com.landmarkdataservice.service.dto.LocalityDtoOut;
import org.springframework.stereotype.Component;

@Component
public class LocalityMapper {


    public Locality toLocalityFromNewDto(LocalityDtoNew localityDtoNew) {
        return Locality.builder()
                .name(localityDtoNew.getName())
                .population(localityDtoNew.getPopulation())
                .metro(localityDtoNew.getMetro())
                .build();

    }

    public LocalityDtoOut toLocalityDto(Locality locality) {
        return LocalityDtoOut.builder()
                .name(locality.getName())
                .population(locality.getPopulation())
                .metro(locality.getMetro())
                .build();

    }


}
