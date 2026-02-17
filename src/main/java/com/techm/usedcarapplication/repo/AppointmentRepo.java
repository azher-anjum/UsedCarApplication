package com.techm.usedcarapplication.repo;

import com.techm.usedcarapplication.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}
