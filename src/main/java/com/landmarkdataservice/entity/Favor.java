package com.landmarkdataservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "favor")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Favor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "short_description")
    private String shortDescription;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "landmark_favor",
            joinColumns = @JoinColumn(name = "favor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "landmark_id", referencedColumnName = "id"))
    @ToString.Exclude
    private List<Landmark> landmarks;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Favor favor = (Favor) o;
        return getId() != null && Objects.equals(getId(), favor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
