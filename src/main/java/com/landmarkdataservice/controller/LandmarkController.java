package com.landmarkdataservice.controller;

import com.landmarkdataservice.service.LandmarkService;
import com.landmarkdataservice.service.dto.LandmarkDtoNew;
import com.landmarkdataservice.service.dto.LandmarkDtoOut;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/landmark")
public class LandmarkController {
    private final LandmarkService landmarkService;

    @Autowired
    public LandmarkController(LandmarkService landmarkService) {
        this.landmarkService = landmarkService;
    }


    @PostMapping(path = "/", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLandmark(@RequestBody @Valid LandmarkDtoNew landmarkDtoNew) {
        landmarkService.createLandmark(landmarkDtoNew);
    }

    @GetMapping(path = "/locality/{localityId}", produces = "application/json")
    public List<LandmarkDtoOut> getAllLandmarkFromLocality(@PathVariable("localityId") Long localityId) {
        return landmarkService.getAllLandmarkByLocalityId(localityId);
    }


    @GetMapping(path = "/all", produces = "application/json")
    public List<LandmarkDtoOut> getAllLandmark(@RequestParam("type") String type) {
        return landmarkService.getAllLandmarkByTypeAndSortByName(type);
    }

    @PatchMapping(path = "/{landmarkId}", params = "shortDescription", produces = "application/json")
    public LandmarkDtoOut updateLandmarkDescription(@PathVariable("landmarkId") Long landmarkId,
                                                    @RequestParam("shortDescription") String shortDescription) {
        return landmarkService.updateLandmark(landmarkId, shortDescription);
    }

    @DeleteMapping(path = "/{landmarkId}", produces = "application/json")
    public void deleteLandmark(@PathVariable("landmarkId") Long landmarkId) {
        landmarkService.deleteLandmarkById(landmarkId);
    }


}
