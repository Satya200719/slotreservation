package com.parking.slotreservation.model;

import com.parking.slotreservation.model.util.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String licensePlate;
	@ManyToOne
	private User user;
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;
	
	public Vehicle() {
		
	}

	public Vehicle(Long id, String licensePlate, User user, VehicleType vehicleType) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.user = user;
		this.vehicleType = vehicleType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", licensePlate=" + licensePlate + ", user=" + user + ", vehicleType="
				+ vehicleType + "]";
	}
	
}
