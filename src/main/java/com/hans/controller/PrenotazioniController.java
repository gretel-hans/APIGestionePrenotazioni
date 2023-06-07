package com.hans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hans.model.PrenotazionePostazione;
import com.hans.service.PrenotazionePostazioneService;

@Controller
@RequestMapping("/gestionePrenotazione/prenotazioni")
public class PrenotazioniController {

	@Autowired PrenotazionePostazioneService prenotazioniService;
	
	@GetMapping()
	public ResponseEntity<List<PrenotazionePostazione>> mostraTuttePrenotazioni() {
		return ResponseEntity.ok(prenotazioniService.cercaTuttePrenotazioni()) ; 
	}
	
	@GetMapping("/page")
	///page?size=2&page=2&sort=name,ASC
	public ResponseEntity<Page<PrenotazionePostazione>> mostraTuttePrenotazioni(Pageable page) {
		return ResponseEntity.ok(prenotazioniService.cercaTuttePrenotazioniPageble(page)) ; 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PrenotazionePostazione> mostraPrenotazioneSpecifica(@PathVariable Long id) {
		return ResponseEntity.ok(prenotazioniService.cercaPrenotazionePostazione(id)) ; 
	}
	
	@PostMapping()
	public ResponseEntity<?> mostraPrenotazioneSpecifica(@RequestBody PrenotazionePostazione p) {
		boolean s=prenotazioniService.salvaOModficaPrenotazionePostazione(p);
		if (s) {
			return new ResponseEntity(prenotazioniService.cercaPrenotazionePostazione(p.getId()),HttpStatus.OK) ; 			
		}else
			return new ResponseEntity("ERRORE!! Nella creazione della nuova prenotazione",HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> mostraPrenotazioneSpecifica(@RequestBody PrenotazionePostazione p, @PathVariable Long id) {
		if(prenotazioniService.esistePrenotazione(id)) {
			boolean s=prenotazioniService.salvaOModficaPrenotazionePostazione(p);
			if (s) {
				return new ResponseEntity(prenotazioniService.cercaPrenotazionePostazione(p.getId()),HttpStatus.OK) ; 			
			}else {
				return new ResponseEntity("ERRORE!! Nella modifica della prenotazione",HttpStatus.BAD_REQUEST);}
			 }else 
				 return new ResponseEntity("ERRORE!! L'id del prodotto inserito da voler modificare non esiste! ",HttpStatus.BAD_REQUEST);
		}
			 
	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancellaPrenotazione(@PathVariable Long id){
			return new ResponseEntity(prenotazioniService.cancellaPrenotazione(id),HttpStatus.OK);			
		}












}
	

