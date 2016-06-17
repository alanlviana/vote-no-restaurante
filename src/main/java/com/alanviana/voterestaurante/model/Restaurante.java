package com.alanviana.voterestaurante.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Restaurante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2184410383424479342L;
	
	@Id
	@GeneratedValue
	@NotNull
	private Integer id;
	
	@Length(min=3,max=50)
	private String nome;
	
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
	
	
	
}
