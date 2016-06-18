package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;

import org.junit.Test;
import static org.junit.Assert.*;

public class EnqueteTest {

	@Test(expected=InvalidParameterException.class)
	public void naoPodeSerCriadaSeUmDosRestaurantesForNulo(){
		Restaurante restaurante1 = new Restaurante();
		Restaurante restaurante2 = null;
		
		new Enquete(restaurante1, restaurante2);		
		
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoPodeSerCriadaComResturantesIguais(){
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Outback");
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Outback");
		
		
		new Enquete(restaurante1, restaurante2);		
		
	}
	
	@Test
	public void equalsDeveSerIgualParaOutraEnqueteComMesmosRestaurantes(){
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Outback");
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Starbucks");
		
		Enquete enquete1 = new Enquete(restaurante1,restaurante2);
		Enquete enquete2 = new Enquete(restaurante1,restaurante2);
		Enquete enquete3 = new Enquete(restaurante2,restaurante1);
		
		assertTrue(enquete1.equals(enquete2));
		assertTrue(enquete1.equals(enquete3));
		
	}
	
	@Test
	public void equalDeveSerDiferenteParaEnquetesComResturantesDiferentes(){
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Outback");
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Starbucks");
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setNome("Big Kahuna Burger");
		
		Enquete enquete1 = new Enquete(restaurante1,restaurante2);
		Enquete enquete2 = new Enquete(restaurante1,restaurante3);
		
		assertFalse(enquete1.equals(enquete2));
		
	}
	
	
	
}
