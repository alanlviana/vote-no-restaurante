package com.alanviana.voterestaurante.dao;

import java.util.List;

import com.alanviana.voterestaurante.model.PosicaoRanking;
import com.alanviana.voterestaurante.model.Questionario;

public interface VotoDAO {

	public List<PosicaoRanking> contarTodosAgrupandoPorRestaurante();

	public List<PosicaoRanking> contarTodosAgrupandoPorRestauranteFiltrandoPorQuestionario(Questionario questionario); 
	
}
