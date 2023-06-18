package com.lsousa.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lsousa.dojosandninjas.models.Dojo;
import com.lsousa.dojosandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	private DojoService dService;
	
	@GetMapping("/dojos/{dojo_id}")
	public String dojos(@PathVariable("dojo_id") Long id, Model model) {
		model.addAttribute("dojo", dService.getOne(id));
		
		return "dojos/dojos.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo dojo) {
		return "dojos/newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("newDojo") Dojo dojo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "dojos/newDojo.jsp";
		} else {
			Dojo newDojo = dService.save(dojo);
			return "redirect:/dojos/" + newDojo.getId();
		}
	}
}
