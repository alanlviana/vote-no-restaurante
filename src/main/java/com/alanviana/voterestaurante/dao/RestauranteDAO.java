package com.alanviana.voterestaurante.dao;

import java.util.List;

import com.alanviana.voterestaurante.model.Restaurante;

public interface RestauranteDAO {

	void add(Restaurante restaurante);
	List<Restaurante> listAll();
	
}
