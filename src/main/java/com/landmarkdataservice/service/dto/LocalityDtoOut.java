package com.landmarkdataservice.service.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LocalityDtoOut {

    private String name;
    private Long population;
    private Boolean metro;
}
