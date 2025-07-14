package com.parking.slotreservation.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parking.slotreservation.model.ParkingSlot;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

	// Optional: Find slot by number
	ParkingSlot findBySlotNumber(String slotNumber);

	List<ParkingSlot> findByIsActiveTrue();

	@Query("""
			    SELECT ps FROM ParkingSlot ps
			    WHERE ps.isActive = true AND ps.id NOT IN (
			        SELECT r.parkingSlot.id FROM Reservation r
			        WHERE CURRENT_DATE BETWEEN r.startTime AND r.endTime
			    )
			""")
	List<ParkingSlot> findAvailableSlotsToday();

}
