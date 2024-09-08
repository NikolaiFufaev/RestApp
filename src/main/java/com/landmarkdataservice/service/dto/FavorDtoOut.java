package com.landmarkdataservice.service.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class FavorDtoOut {
    private String name;
    private String shortDescription;
}
