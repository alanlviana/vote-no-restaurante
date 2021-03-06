package com.alanviana.voterestaurante.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Restaurante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2184410383424479342L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
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
	
	@Override
	public boolean equals(Object object){
		
		if (object == null) {
			
		}
		
		if (!(object instanceof Restaurante)){
			return false;
		}
		
		Restaurante referencia = (Restaurante) object;
		if (this.id == null || referencia.getId() == null){
			return false;
		}
		
		return this.id.equals(referencia.getId());
	}
	
	@Override
	public String toString(){
		return this.id.toString();
	}
	
	
}
