package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GeradorEnquete {

	private final Set<Restaurante> restaurantes;
	
	public GeradorEnquete(Set<Restaurante> restaurantes) {
		
		if (restaurantes == null){
			throw new InvalidParameterException("Lista de Restaurates não pode ser nula.");
		}
		
		if (restaurantes.size() < 2){
			throw new InvalidParameterException("Lista de Restaurates não pode ter menos de 2 restaurantes.");
		}
		
		this.restaurantes = restaurantes;
		
	}

	public List<Enquete> gerarLista() {
		
		List<Enquete> enquetes = new ArrayList<Enquete>();
		List<Restaurante> listaRestaurantes  = new ArrayList<>(restaurantes);
		
		int i = 0;
		while ( i != listaRestaurantes.size() -1) {
			Restaurante restaurante1 = listaRestaurantes.get(i);
			
			for (int j = i +1; j < listaRestaurantes.size(); j++){
				Restaurante restaurante2 = listaRestaurantes.get(j);
				enquetes.add(new Enquete(restaurante1, restaurante2));
			}
			i++;
		}
		
		Collections.shuffle(enquetes);
		
		return enquetes;
	}
}
