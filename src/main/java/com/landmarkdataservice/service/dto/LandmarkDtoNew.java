package com.landmarkdataservice.service.dto;

import lombok.*;
import org.springframework.lang.NonNull;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LandmarkDtoNew {
    @NonNull
    private String name;
    private String shortDescription;
    @NonNull
    private String type;
    @NonNull
    private Long localityId;
    private List<FavorDtoNew> favors;

}
