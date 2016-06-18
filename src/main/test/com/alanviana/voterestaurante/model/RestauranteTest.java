package com.alanviana.voterestaurante.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestauranteTest {

	@Test
	public void deveConsiderarIguaisRestaurantesComMesmoNome(){
		
		Restaurante restaurante1 = new Restaurante();
		Restaurante restaurante2 = new Restaurante();
		
		restaurante1.setNome("Outback");
		restaurante2.setNome("Outback");
		
		assertTrue(restaurante1.equals(restaurante2));	
	}
	
	@Test
	public void deveConsiderarDiferentesRestaurantesComNomeDifernete(){
		
		Restaurante restaurante1 = new Restaurante();
		Restaurante restaurante2 = new Restaurante();
		
		restaurante1.setNome("Outback");
		restaurante2.setNome("Starbucks");
		
		assertFalse(restaurante1.equals(restaurante2));
		
		
	}	
	
}
