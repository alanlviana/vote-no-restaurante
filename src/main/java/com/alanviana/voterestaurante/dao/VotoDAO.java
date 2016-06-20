package com.alanviana.voterestaurante.dao;

import java.util.HashMap;

import com.alanviana.voterestaurante.model.Restaurante;

public interface VotoDAO {

	public HashMap<Restaurante, Integer> contarTodosAgrupandoPorRestaurante(); 
	
}
