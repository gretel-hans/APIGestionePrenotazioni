package com.hans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hans.model.PrenotazionePostazione;
import com.hans.service.PrenotazionePostazioneService;

@Controller
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@Autowired PrenotazionePostazioneService prenotazioniService;
	
	@GetMapping("/{id}")
	public ModelAndView mostraTuttePrenotazioni(@PathVariable Long id) {
		PrenotazionePostazione p=prenotazioniService.cercaPrenotazionePostazione(id);
		return new ModelAndView("prenotazioneSingola","prenotazione",p);
	}
}
