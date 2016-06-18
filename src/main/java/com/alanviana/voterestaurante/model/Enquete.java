package com.alanviana.voterestaurante.model;

import java.io.Serializable;
import java.security.InvalidParameterException;

public class Enquete implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7773668612133864520L;
	
	private final Restaurante restaurante1;
	private final Restaurante restaurante2;
	
	public Enquete(Restaurante restaurante1, Restaurante restaurante2) {
		
		if (restaurante1 == null || restaurante2 == null) {
			throw new InvalidParameterException("Restaurante para enquete não pode ser nulo.");
		}
		
		if (restaurante1.equals(restaurante2)){
			throw new InvalidParameterException("Restaurantes para enquete não podem ser iguais.");
		}
		
		this.restaurante1 = restaurante1;
		this.restaurante2 = restaurante2;
	}

	public Restaurante getRestaurante1() {
		return restaurante1;
	}

	public Restaurante getRestaurante2() {
		return restaurante2;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (object == null){
			return false;
		}
		
		if (!(object instanceof Enquete)) {
			return false;
		}
		
		Enquete referencia = (Enquete) object;
		
		boolean condicao1 = (this.restaurante1.equals(referencia.restaurante1)) && (this.restaurante2.equals(referencia.restaurante2));
		boolean condicao2 = (this.restaurante1.equals(referencia.restaurante2)) && (this.restaurante2.equals(referencia.restaurante1));		
		
		if (condicao1 || condicao2){
			return true;
		}
		
		return false;
	}
	
    
}

