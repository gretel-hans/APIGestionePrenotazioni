package com.hans.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hans.model.Edificio;
import com.hans.repository.EdificioRepository;

@Service
public class EdificioService {

	@Autowired EdificioRepository db;
	
	@Autowired @Qualifier("FakeEdificio") ObjectProvider<Edificio> fakeEdificioProvider;
	
	public Edificio creaEdificio() {
		return fakeEdificioProvider.getObject();
	}
	
	public void salvaOModificaEdificio(Edificio e) {
		db.save(e);
		System.out.println("Edificio: "+e.getNome()+" stato salvato nel DB!");
	}
	
	public Edificio cercaEdificio(long id) {
		return db.findById(id).get();
	}
	
	public List<Edificio> cercaTuttiEdifici(){
		return db.findAll();
	}
	
	
}
