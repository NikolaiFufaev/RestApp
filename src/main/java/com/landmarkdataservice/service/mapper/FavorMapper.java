package com.landmarkdataservice.service.mapper;

import com.landmarkdataservice.entity.Favor;
import com.landmarkdataservice.repository.FavorRepository;
import com.landmarkdataservice.service.dto.FavorDtoNew;
import com.landmarkdataservice.service.dto.FavorDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FavorMapper {
    private final FavorRepository favorRepository;

    @Autowired
    public FavorMapper(FavorRepository favorRepository) {
        this.favorRepository = favorRepository;
    }

    public List<Favor> toListFavorById(List<FavorDtoNew> favors) {
        List<Favor> favorList = new ArrayList<>();
        for (FavorDtoNew dtoNew : favors) {
            favorRepository.findById(dtoNew.getId()).ifPresent(favorList::add);
        }
        return favorList;
    }

    public FavorDtoOut toFavorDtoOut(Favor favor) {
        return FavorDtoOut.builder()
                .name(favor.getName())
                .shortDescription(favor.getShortDescription())
                .build();
    }

    public List<FavorDtoOut> toListFavorDtoOut(List<Favor> favors) {
        if (favors == null || favors.isEmpty()) {
            return new ArrayList<>();
        }
        List<FavorDtoOut> favorDtoOuts = new ArrayList<>();
        for (Favor favor : favors) {
            favorDtoOuts.add(toFavorDtoOut(favor));
        }
        return favorDtoOuts;
    }


}
