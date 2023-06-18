package com.lsousa.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lsousa.dojosandninjas.models.Ninja;
import com.lsousa.dojosandninjas.services.DojoService;
import com.lsousa.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService nService;
	
	@Autowired
	private DojoService dService;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dService.getAll());
		
		return "ninjas/newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ninjas/newNinja.jsp";
		} else {
			Ninja newNinja = nService.save(ninja);
			
			return "redirect:/dojos/" + newNinja.getDojo().getId();
		}
	}
}
