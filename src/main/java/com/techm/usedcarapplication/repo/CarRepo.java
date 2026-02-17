package com.techm.usedcarapplication.repo;

import com.techm.usedcarapplication.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Integer> {

    List<Car> findByFuelTypeAndCapacityAndCarBrand(String fuelType, int i, String carBrand);
}
