package com.parking.slotreservation.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import com.parking.slotreservation.model.Reservation;

@Entity
public class ParkingSlot {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 10)
	private String slotNumber;
	private String location;
	private boolean isActive;
	
	@OneToMany(mappedBy = "parkingSlot")
	private List<Reservation> reservations = new ArrayList<>();

	
	public ParkingSlot() {
		
	}
	
	public ParkingSlot(Long id, String slotNumber, String location, boolean isActive) {
		super();
		this.id = id;
		this.slotNumber = slotNumber;
		this.location = location;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "ParkingSlot [id=" + id + ", slotNumber=" + slotNumber + ", location=" + location + ", isActive="
				+ isActive + ", reservations=" + reservations + "]";
	}
	
}
