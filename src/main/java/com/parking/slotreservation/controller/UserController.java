package com.parking.slotreservation.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.parking.slotreservation.model.ParkingSlot;
import com.parking.slotreservation.model.Reservation;
import com.parking.slotreservation.model.User;
import com.parking.slotreservation.repository.ParkingSlotRepository;
import com.parking.slotreservation.repository.ReservationRepository;
import com.parking.slotreservation.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
    private ParkingSlotRepository repository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/dashboard")
	public String showDashboard(Model model, Principal principal) {
	    String username = principal.getName();
	    User user = userRepository.findByUsername(username);
	    
	    List<ParkingSlot> availableSlots = repository.findAvailableSlotsToday();
	    List<Reservation> myReservations = reservationRepository.findByUserId(user.getId());

	    model.addAttribute("availableSlots", availableSlots);
	    model.addAttribute("reservations", myReservations);
	    return "user-dashboard";
	}

}
