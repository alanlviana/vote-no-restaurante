package com.alanviana.voterestaurante.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alanviana.voterestaurante.model.Restaurante;

public class RestauranteTest {

	@Test
	public void deveConsiderarIguaisRestaurantesComMesmoId(){
		
		Restaurante restaurante1 = new Restaurante();
		Restaurante restaurante2 = new Restaurante();
		
		restaurante1.setId(1);
		restaurante2.setId(1);
		
		assertTrue(restaurante1.equals(restaurante2));	
	}
	
	@Test
	public void deveConsiderarDiferentesRestaurantesComIdDiferente(){
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(1);
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setId(2);
		
		assertFalse(restaurante1.equals(restaurante2));
		
	}	
	
}
