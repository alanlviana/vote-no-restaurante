package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class GeradorEnquete {

	private final List<Restaurante> restaurantes;
	
	public GeradorEnquete(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
		
		if (restaurantes == null){
			throw new InvalidParameterException("Lista de Restaurates não pode ser nula.");
		}
		
		if (restaurantes.size() < 2){
			throw new InvalidParameterException("Lista de Restaurates não pode ter menos de 2 restaurantes.");
		}
		
	}

	public List<Enquete> gerar() {
		
		List<Enquete> enquetes = new ArrayList<Enquete>();
		
		int i = 0;
		while ( i != restaurantes.size() -1) {
			Restaurante restaurante1 = restaurantes.get(i);
			
			for (int j = i +1;j < restaurantes.size();j++){
				Restaurante restaurante2 = restaurantes.get(j);
				enquetes.add(new Enquete(restaurante1, restaurante2));
			}
			
			i++;
		}
		
		return enquetes;
	}
	
	//publi coi
}
