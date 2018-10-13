package com.gimnazijam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gimnazijam.entities.Zaposleni;
import com.gimnazijam.repositories.ZaposleniRepository;

@Controller
public class ZaposleniController {

	@Autowired
	private ZaposleniRepository zaposleniRepository;

	@RequestMapping(value = "/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("welcome");
		return model;
	}

	@RequestMapping("/zaposleni")
	public String index(Model model) {
		List<Zaposleni> zaposlenis = (List<Zaposleni>) zaposleniRepository.findAll();
		model.addAttribute("zaposleni", zaposlenis);
		return "zaposleni";
	}

	@RequestMapping(value = "addZaposleni")
	public String addZaposleni(Model model) {
		model.addAttribute("zaposleni", new Zaposleni());
		return "addZaposleni";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editZaposleni(@PathVariable("id") int zaposleni_id, Model model) {
		model.addAttribute("zaposleni", zaposleniRepository.findById(zaposleni_id));
		return "editZaposleni";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@PathVariable("id") int zaposleni_id, Model model) {
		zaposleniRepository.save(zaposleni_id);
		return "redirect:/zaposleni";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteZaposleni(@PathVariable("id") int zaposleni_id, Model model) {
		zaposleniRepository.deleteById(zaposleni_id);
		return "redirect:/zaposleni";
	}

}
