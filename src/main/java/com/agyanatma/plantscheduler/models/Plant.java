package com.agyanatma.plantscheduler.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "soaking_time")
    private Integer soakingTime;

    @Column(name = "start_harvest")
    private Integer startHarvest;

    @Column(name = "end_harvest")
    private Integer endHarvest;

    @Column(name = "shoots_appear")
    private Integer shootsAppear;

    @ManyToMany
    @JoinTable(
            name = "plant_locations",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> location;

}
