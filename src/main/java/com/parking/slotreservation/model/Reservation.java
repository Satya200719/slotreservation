package com.parking.slotreservation.model;

import java.time.LocalDate;

import com.parking.slotreservation.model.util.ReservationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private ParkingSlot parkingSlot;
	private LocalDate startTime;
	private LocalDate endTime;
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;
	
	public Reservation() {
		
	}

	public Reservation(Long id, User user, ParkingSlot parkingSlot, LocalDate startTime, LocalDate endTime, ReservationStatus status) {
		super();
		this.id = id;
		this.user = user;
		this.parkingSlot = parkingSlot;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", user=" + user + ", parkingSlot=" + parkingSlot + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", status=" + status + "]";
	}

}
