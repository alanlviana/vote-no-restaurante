package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GeradorEnquete {

	private final Set<Restaurante> restaurantes;
	
	public GeradorEnquete(Set<Restaurante> restaurantes) {
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
		
		// Cria um arrayList a partir do set, já sabemos que arrayList não terá itens repetidos por a classe set não permite
		// E com implementações de List temos acesso fácil aos itens atráves do indice 
		List<Restaurante> listaRestaurantes  = new ArrayList<>(restaurantes);
		
		int i = 0;
		// Percorre a lista
		while ( i != listaRestaurantes.size() -1) {
			Restaurante restaurante1 = listaRestaurantes.get(i);
			
			// Percorre novamente só com elementos que estão a sua frente
			for (int j = i +1;j < listaRestaurantes.size();j++){
				Restaurante restaurante2 = listaRestaurantes.get(j);
				enquetes.add(new Enquete(restaurante1, restaurante2));
			}
			i++;
		}
		
		return enquetes;
	}
}
