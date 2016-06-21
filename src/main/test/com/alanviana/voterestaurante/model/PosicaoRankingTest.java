package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import static org.junit.Assert.*;
import org.junit.Test;

public class PosicaoRankingTest {

	@Test(expected=InvalidParameterException.class)
	public void naoDeveAceitarRestauranteNulo(){
		Restaurante restaurante = null;
		Integer quantidade = 0;
		
		new PosicaoRanking(restaurante, quantidade);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDeveAceitarPosicaoMenorIgualAZero(){
		Restaurante restaurante = new Restaurante();
		Integer quantidade = 0;
		
		PosicaoRanking posicaoRanking = new PosicaoRanking(restaurante, quantidade);
		posicaoRanking.setPosicao(0);
	}
	
	
	@Test(expected=InvalidParameterException.class)
	public void quantidadeNaoDeveSerNula(){
		Restaurante restaurante = new Restaurante();
		
		new PosicaoRanking(restaurante, null);
	}		
	
	@Test
	public void posicoesComMesmoRestauranteDevemSerConsideradasIguais(){
		Restaurante restaurante1 = new Restaurante();		
		restaurante1.setId(1);
		Restaurante restaurante2 = new Restaurante();		
		restaurante2.setId(1);		
		
		PosicaoRanking posicaoRanking1 = new PosicaoRanking(restaurante1, 200);
		PosicaoRanking posicaoRanking2 = new PosicaoRanking(restaurante2, 400);
		
		assertTrue(posicaoRanking1.equals(posicaoRanking2));
		
	}
	
	@Test
	public void posicoesComRestauranteDiferentesDevemSerConsideradasDiferentes(){
		Restaurante restaurante1 = new Restaurante();		
		restaurante1.setId(1);
		Restaurante restaurante2 = new Restaurante();		
		restaurante2.setId(2);		
		
		PosicaoRanking posicaoRanking1 = new PosicaoRanking(restaurante1, 200);
		PosicaoRanking posicaoRanking2 = new PosicaoRanking(restaurante2, 400);
		
		assertFalse(posicaoRanking1.equals(posicaoRanking2));
		
	}	
	
	@Test
	public void deveSerComparavelPelaQuantidadeDeVotos(){
		Restaurante restaurante1 = new Restaurante();		
		restaurante1.setId(1);
		Restaurante restaurante2 = new Restaurante();		
		restaurante2.setId(2);		
		Restaurante restaurante3 = new Restaurante();		
		restaurante3.setId(3);		
		
		PosicaoRanking posicaoRanking1 = new PosicaoRanking(restaurante1, 200);
		PosicaoRanking posicaoRanking2 = new PosicaoRanking(restaurante2, 400);
		PosicaoRanking posicaoRanking3 = new PosicaoRanking(restaurante3, 400);		
		
		assertTrue(posicaoRanking2.compareTo(posicaoRanking1) > 0);
		assertTrue(posicaoRanking1.compareTo(posicaoRanking2) < 0);
		assertTrue(posicaoRanking3.compareTo(posicaoRanking2) == 0);		
	}
	
}
