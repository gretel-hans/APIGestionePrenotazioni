package com.hans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class InfoController {

	String it="Benvenuto nel sito!<br/>Un utente può prenotare solo una postazione per un giorno, in quanto la prenotazione dura una giornata, oltre a ciò non si può prenotare una postazione prima di due giorni dalla data nella quale si vuole prenotare.<br/>Un utente può effettuare la ricerca di una postazione desiderata indicando il tipo di postazione e la città di interesse";
	String en="Welcome to the site!<br/>A user can only book a seat for one day, as the reservation lasts a day, in addition you cannot book a seat before two days from the date you want to book.<br/>A user can search for a desired location indicating the type of location and the city of interest";
	
	@GetMapping("/info/it")
	public String getPrenotazioniInfoIt(){
			return it;
	}
	
	@GetMapping("/info/en")
	public String getPrenotazioniInfoEn(){
			return "Welcome to the site istructions!!";
	}
	
	@GetMapping("/info/*")
	public String getPrenotazioniInfoError(){
			return "ERRORE!!!  Inserisci una lingua valida!! ( 'it' o 'en' )";
	}
	
	
}
