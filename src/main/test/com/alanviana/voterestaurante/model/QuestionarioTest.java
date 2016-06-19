package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class QuestionarioTest {

	private List<Restaurante> restaurantes;
	
	@Before
	public void setup(){
		restaurantes = new ArrayList<Restaurante>();
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Outback");
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Starbucks");
		Restaurante restaurante3 = new Restaurante();
		restaurante3.setNome("The fifties");		
		Restaurante restaurante4 = new Restaurante();
		restaurante4.setNome("Big Kahuna Burger");
		
		restaurantes.add(restaurante1);
		restaurantes.add(restaurante2);
		restaurantes.add(restaurante3);
		restaurantes.add(restaurante4);
		
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirNomeNulo(){
		String nome = null;
		String email = "teste@teste.com.br";
				
		new Questionario(nome, email, restaurantes);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirNomeVazio(){
		String nome = "";
		String email = "teste@teste.com.br";
				
		new Questionario(nome, email, restaurantes);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirEmailNulo(){
		String nome = "Teste";
		String email = null;
				
		new Questionario(nome, email, restaurantes);		
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirEmailVazio(){
		String nome = "Teste";
		String email = "";
				
		new Questionario(nome, email, restaurantes);		
	}
	
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirListaNula(){
		String nome = "Teste";
		String email = "teste@teste.com.br";
				
		new Questionario(nome, email, null);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void naoDevePermitirListaVazia(){
		String nome = "Teste";
		String email = "teste@teste.com.br";
				
		new Questionario(nome, email, new ArrayList<>());
	}	
	
	@Test
	public void deveGerarQuestionarioComQuantidadeVotosRestaurantesIgual(){
		
		String nome = "Teste";
		String email = "teste@teste.com.br";
				
		Questionario questionario = new Questionario(nome, email, restaurantes);
		assertEquals(4, questionario.getVotos().size());
		
	}
	
	
	
}
