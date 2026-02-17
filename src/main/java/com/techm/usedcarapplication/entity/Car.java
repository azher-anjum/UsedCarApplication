package com.techm.usedcarapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @NotEmpty
    private String registrationNumber;

    @NotEmpty
    private String carBrand;
    @NotEmpty
    private String carName;

    private String ownerName;
    private String ownerContactNumber;


    private int mileage;

    private String fuelType;
    private int capacity;

    private String price;


    @JsonIgnore
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

}