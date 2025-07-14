package com.parking.slotreservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.slotreservation.model.ParkingSlot;
import com.parking.slotreservation.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	// Custom finder (useful for login)
    User findByUsername(String username);

}
