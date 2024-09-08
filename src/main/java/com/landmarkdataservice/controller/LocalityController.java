package com.landmarkdataservice.controller;

import com.landmarkdataservice.service.LocalityService;
import com.landmarkdataservice.service.dto.LocalityDtoNew;
import com.landmarkdataservice.service.dto.LocalityDtoOut;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/locality")
public class LocalityController {
    private final LocalityService localityService;

    @Autowired
    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }


    @PostMapping(path = "/", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLocality(@RequestBody @Valid LocalityDtoNew localityDtoNew) {
        localityService.createLocality(localityDtoNew);
    }

    @PatchMapping(path = "/{localityId}")
    public LocalityDtoOut updateLocalityByPopulationAndMetro(@PathVariable("localityId") Long localityId,
                                                             @RequestParam(name = "population"
                                                                     , required = false) Long population,
                                                             @RequestParam(name = "metro"
                                                                     , required = false) Boolean metro) {
        return localityService.updateLocalityById(localityId, metro, population);
    }
}
