package com.hans.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hans.Enums.TipoPostazione;
import com.hans.model.Edificio;
import com.hans.model.Postazione;
import com.hans.repository.PostazioneRepository;

import lombok.Getter;

@Service
@Getter
public class PostazioneService {

	@Autowired PostazioneRepository db;
	
	@Autowired @Qualifier("NuovaPostazione") ObjectProvider<Postazione> nuovaPostazioneProvider;
	
	public Postazione creaPostazione() {
		return nuovaPostazioneProvider.getObject();
	}
	
	public void salvaOModificaPostazione(Postazione p) {
		db.save(p);
		System.out.println("Postazione con id: "+p.getId()+" salvato nel DB!");
	}
	
	public Postazione cercaPostazione(long id) {
		return db.findById(id).get(); 
	} 
	
	public List<Postazione> cercaPostazionePerTipoCitta(String citta, TipoPostazione tipo){
		return db.cercaPostazionePerTipoCitta(citta, tipo);
	}
	
	public List<Postazione> cercaTuttePostazioni(){
		return db.findAll();
	}
	
public void cercaPostazioneAzienda(Edificio e) {
	int n=db.cercaNumeroPostazioniAzienda(e);
	if(n==0) {
		System.out.println(e.getNome()+" non ha postazioni attualmente salvate nel DB!");
	}else if(n>0) {
		System.out.println(e.getNome()+" ha: "+n+" postazioni salvate nel DB!");
	}
}

	
}
