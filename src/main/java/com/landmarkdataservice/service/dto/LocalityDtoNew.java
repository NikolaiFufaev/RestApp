package com.landmarkdataservice.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LocalityDtoNew {
   @NonNull
   private String name;
   private Long population;
   private Boolean metro;
}
