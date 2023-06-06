package com.hans.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="utenti")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Utente {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String email;

	public Utente(String username, String nome, String cognome, String email) {
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	
	
	

	
}
