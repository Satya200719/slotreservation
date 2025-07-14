package com.parking.slotreservation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.slotreservation.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	// Find all reservations for a user
	List<Reservation> findByUserId(Long userId);

	// Find reservations for a slot on a given day (for conflict checking)
	List<Reservation> findByParkingSlotIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Long slotId, LocalDate end,
			LocalDate start);

	boolean existsByParkingSlotIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Long slotId, LocalDate end,
			LocalDate start);

}
