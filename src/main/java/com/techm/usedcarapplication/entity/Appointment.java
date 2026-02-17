package com.techm.usedcarapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "appointments")
public class Appointment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    private String name;
    private String type;
    private String date;

//    @OneToOne(mappedBy = "appointment")
//    private Car car;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;


}
