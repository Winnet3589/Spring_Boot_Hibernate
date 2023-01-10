package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.CitizenIDCardDto;
import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.CitizenIDCardDServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CitizenIDCardDController {

	private final CitizenIDCardDServiceImpl citizenIDCardDService;

	@GetMapping(value= "/citizenidcard-list-dto")
	public List<CitizenIDCardDto> listAddressDto() {
		return MapStructMapper.INSTANCE.mapCitizenIDCardFromEntityToDtoList(citizenIDCardDService.findAll());
	}

	@GetMapping(value= "/citizenidcard-list")
	public List<CitizenIDCard> listAddress() {
		return citizenIDCardDService.findAll();
	}


//	@RequestMapping("/customer-save")
//	public String insertCustomer(Model model) {
//		model.addAttribute("customer", new Customer());
//		return "customer-save";
//	}
//
//	@RequestMapping("/customer-view/{id}")
//	public String viewCustomer(@PathVariable int id, Model model) {
//		Customer customer = customerService.findById(id);
//		model.addAttribute("customer", customer);
//		return "customer-view";
//	}
//
//	@RequestMapping("/customer-update/{id}")
//	public String updateCustomer(@PathVariable int id, Model model) {
//		Customer customer = customerService.findById(id);
//		model.addAttribute("customer", customer);
//		return "customer-update";
//	}
//
//	@RequestMapping("/saveCustomer")
//	public String doSaveCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
//		customerService.save(customer);
//		model.addAttribute("listCustomer", customerService.findAll());
//		return "redirect:customer-list";
//	}
//
//	@RequestMapping("/updateCustomer")
//	public String doUpdateCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
//		customerService.update(customer);
//		model.addAttribute("listCustomer", customerService.findAll());
//		return "redirect:customer-list";
//	}
//
//	@RequestMapping("/customerDelete/{id}")
//	public String doDeleteCustomer(@PathVariable int id, Model model) {
//		customerService.delete(id);
//		model.addAttribute("listCustomer", customerService.findAll());
//		return "redirect:/customer-list";
//	}
}
