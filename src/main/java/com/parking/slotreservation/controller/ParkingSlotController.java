package com.parking.slotreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parking.slotreservation.model.ParkingSlot;
import com.parking.slotreservation.repository.ParkingSlotRepository;

@Controller
public class ParkingSlotController {

	@Autowired
	private ParkingSlotRepository repository;

	@GetMapping("/admin/slots")
	public String viewAllSlots(ModelMap model) {
		model.put("slots", repository.findAll());
		return "admin-slots";
	}

	@GetMapping("/admin/slots/add")
	public String showAddSlotForm(Model model) {
		model.addAttribute("slot", new ParkingSlot());
		return "add-slot";
	}

	@PostMapping("/admin/slots/add")
	public String addNewSlot(@ModelAttribute("slot") ParkingSlot slot) {
		repository.save(slot);
		return "redirect:/admin/slots";
	}

	@GetMapping("/admin/slots/delete/{id}")
	public String deleteSlotById(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
		return "redirect:/admin/slots";
	}

}
