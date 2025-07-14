package com.parking.slotreservation.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parking.slotreservation.model.ParkingSlot;
import com.parking.slotreservation.model.Reservation;
import com.parking.slotreservation.model.User;
import com.parking.slotreservation.model.util.ReservationStatus;
import com.parking.slotreservation.repository.ParkingSlotRepository;
import com.parking.slotreservation.repository.ReservationRepository;
import com.parking.slotreservation.repository.UserRepository;

@Controller
public class ReservationController {

	@Autowired
	private ParkingSlotRepository slotRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/reserve/{slotId}")
	public String showReservationForm(@PathVariable Long slotId, ModelMap model) {
		ParkingSlot slot = slotRepository.findById(slotId).orElseThrow();
		Reservation reservation = new Reservation();
		reservation.setParkingSlot(slot);
		model.addAttribute("reservation", reservation);
		return "reserve-slot";
	}

	@PostMapping("/user/reserve")
	public String submitReservation(@ModelAttribute Reservation reservation, ModelMap model, Principal principal) {

		String username = principal.getName();
		User user = userRepository.findByUsername(username);
		reservation.setUser(user);

		Long slotId = reservation.getParkingSlot().getId();
		LocalDate start = reservation.getStartTime();
		LocalDate end = reservation.getEndTime();

		boolean isConflict = reservationRepository
				.existsByParkingSlotIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(slotId, end, start);

		if (isConflict) {
			model.addAttribute("reservation", reservation);
			model.addAttribute("error", "This slot is already reserved during the selected time.");
			return "reserve-slot";
		}

		reservation.setStatus(ReservationStatus.PENDING);
		reservationRepository.save(reservation);
		return "redirect:/user/dashboard";
	}

}
