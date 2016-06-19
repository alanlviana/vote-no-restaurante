package com.alanviana.voterestaurante.model;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Questionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4317124537651053552L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private String nome;
	@NotNull
	private String email;	
	private List<Voto> votos;

	public Questionario(){}
	
	public Questionario(String nome, String email,List<Restaurante> restaurantes) {
		this.nome = nome;
		this.email = email;
		
		if (nome == null || "".equals(nome)) {
			throw new InvalidParameterException("Nome não pode ser nulo ou vazio.");
		}
		
		if (email == null || "".equals(email)) {
			throw new InvalidParameterException("Email não pode ser nulo ou vazio.");
		}
		
		if (restaurantes == null || restaurantes.isEmpty()) {
			throw new InvalidParameterException("Lista de restaurantes não pode ser nula ou vazio.");
		}
		
		this.votos = new ArrayList<>();
		for(Restaurante restaurante : restaurantes){
			Voto voto = new Voto();
			voto.setRestaurante(restaurante);
			votos.add(voto);
		}		
		
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
		
}
