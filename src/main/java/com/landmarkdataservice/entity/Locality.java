package com.landmarkdataservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "locality")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Long population;
    @OneToMany(mappedBy = "locality", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Landmark> landmarks;
    @Column(nullable = false)
    private Boolean metro;


}
