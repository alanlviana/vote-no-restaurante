package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

import com.alanviana.voterestaurante.model.GeradorRanking;
import com.alanviana.voterestaurante.model.PosicaoRanking;
import com.alanviana.voterestaurante.model.Restaurante;

public class GeradorRankingTest {

	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirAdicionarRestauranteNulo(){
		Restaurante restaurante = null;
		Integer quantidadeVotos = 1;
		GeradorRanking geradorRanking = new GeradorRanking();
		geradorRanking.adicionarRestaurante(restaurante,quantidadeVotos);
		
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirAdicionarRestauranteComVotoNulo(){
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1);
		Integer quantidadeVotos = null;
		
		GeradorRanking geradorRanking = new GeradorRanking();
		geradorRanking.adicionarRestaurante(restaurante,quantidadeVotos);
		
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirAdicionarRestauranteRepetido(){
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1);
		Integer quantidadeVotos = 1;
		
		GeradorRanking geradorRanking = new GeradorRanking();
		geradorRanking.adicionarRestaurante(restaurante,quantidadeVotos);
		geradorRanking.adicionarRestaurante(restaurante,quantidadeVotos);
		
	}
	
	@Test(expected=IllegalStateException.class)
	public void naoDeveGerarListaVazia(){
		
		GeradorRanking geradorRanking = new GeradorRanking();
		geradorRanking.gerarListaPosicoes();
		
	}	
		
	
	@Test
	public void deveGerarListaDePosicoesComMesmaQuantidadeDeRestaurantes(){
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(1);
		Integer quantidadeVotos1 = 1;
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setId(2);
		Integer quantidadeVotos2 = 2;
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setId(3);
		Integer quantidadeVotos3 = 3;		
		
		GeradorRanking geradorRanking = new GeradorRanking();
		
		geradorRanking.adicionarRestaurante(restaurante1,quantidadeVotos1);
		geradorRanking.adicionarRestaurante(restaurante2,quantidadeVotos2);
		geradorRanking.adicionarRestaurante(restaurante3,quantidadeVotos3);
		
		List<PosicaoRanking> ranking = geradorRanking.gerarListaPosicoes();
		assertEquals(3, ranking.size());
		
	}
	
	@Test
	public void deveGerarPosicoesCorretamente(){
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(1);
		Integer quantidadeVotos1 = 500;
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setId(2);
		Integer quantidadeVotos2 = 300;
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setId(3);
		Integer quantidadeVotos3 = 600;
		Restaurante restaurante4 = new Restaurante();
		restaurante4.setId(4);
		Integer quantidadeVotos4 = 700;		
		
		GeradorRanking geradorRanking = new GeradorRanking();
		
		geradorRanking.adicionarRestaurante(restaurante1,quantidadeVotos1);
		geradorRanking.adicionarRestaurante(restaurante2,quantidadeVotos2);
		geradorRanking.adicionarRestaurante(restaurante3,quantidadeVotos3);
		geradorRanking.adicionarRestaurante(restaurante4,quantidadeVotos4);
		
		List<PosicaoRanking> ranking = geradorRanking.gerarListaPosicoes();
		assertTrue(ranking.get(0).getPosicao().equals(1) && ranking.get(0).getRestaurante().equals(restaurante4));
		assertTrue(ranking.get(1).getPosicao().equals(2) && ranking.get(1).getRestaurante().equals(restaurante3));
		assertTrue(ranking.get(2).getPosicao().equals(3) && ranking.get(2).getRestaurante().equals(restaurante1));
		assertTrue(ranking.get(3).getPosicao().equals(4) && ranking.get(3).getRestaurante().equals(restaurante2));		
		
	}			
}
