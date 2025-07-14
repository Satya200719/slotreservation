package com.parking.slotreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.slotreservation.model.Vehicle;
import com.parking.slotreservation.model.util.VehicleType;

@Repository
public interface VehicleTypeRepository extends JpaRepository<Vehicle, Long>{
	
	// Get all vehicles for a user
    List<Vehicle> findByUserId(Long userId);

    // Optional: Find by license plate
    Vehicle findByLicensePlate(String licensePlate);
}
