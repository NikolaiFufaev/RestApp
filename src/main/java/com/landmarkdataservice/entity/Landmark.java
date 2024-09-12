package com.landmarkdataservice.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "landmark")
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(name = "creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    @Column(name = "short_description", nullable = false)
    private String shortDescription;
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Type type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locality_id")
    private Locality locality;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "landmark_favor",
            joinColumns = @JoinColumn(name = "landmark_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "favor_id", referencedColumnName = "id"))
    private List<Favor> favors;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Landmark landmark = (Landmark) o;
        return getId() != null && Objects.equals(getId(), landmark.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}


