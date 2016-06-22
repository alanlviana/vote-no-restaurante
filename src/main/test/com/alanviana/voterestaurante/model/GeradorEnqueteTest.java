package com.alanviana.voterestaurante.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.alanviana.voterestaurante.model.Enquete;
import com.alanviana.voterestaurante.model.GeradorEnquete;
import com.alanviana.voterestaurante.model.Restaurante;

public class GeradorEnqueteTest {
	
	private Set<Restaurante> restaurantes;
	
	@Before
	public void setup(){
		restaurantes = new HashSet<>();
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1);
		restaurante.setNome("Nome 1");
		restaurantes.add(restaurante);
		
		restaurante = new Restaurante();
		restaurante.setId(2);
		restaurante.setNome("Nome 2");
		restaurantes.add(restaurante);		

		restaurante = new Restaurante();
		restaurante.setId(3);
		restaurante.setNome("Nome 3");
		restaurantes.add(restaurante);
		
		restaurante = new Restaurante();
		restaurante.setId(4);
		restaurante.setNome("Nome 4");
		restaurantes.add(restaurante);
		

		restaurante = new Restaurante();
		restaurante.setId(5);
		restaurante.setNome("Nome 5");
		restaurantes.add(restaurante);
	}
	
	
	@Test(expected=InvalidParameterException.class)
	public void deveRecusarListaRestauranteComMenosDe2(){
		Set<Restaurante> lista = new HashSet<>();
		new GeradorEnquete(lista);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void deveRecusarListaNula(){
		new GeradorEnquete(null);
	}
	
	@Test
	public void deveGerarListaComEnquetes(){
		GeradorEnquete gerador = new GeradorEnquete(restaurantes);
		List<Enquete> enquetes =  gerador.gerarLista();
	
		assertNotNull(enquetes);
	}
	
	@Test
	public void deveGerarListaComQuantidadeCorretaDeCombinacoesCom5Restaurantes(){
		GeradorEnquete gerador = new GeradorEnquete(restaurantes);
		List<Enquete> enquetes =  gerador.gerarLista();
	
		assertEquals(10, enquetes.size());
	
	}
	
	@Test
	public void deveGerarListaComQuantidadeCorretaDeCombinacoesCom2Restaurantes(){
		
		Set<Restaurante> listaCom2 = new HashSet<>();
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Outback");
		Restaurante restaurante2 = new Restaurante();
		restaurante1.setNome("Starbucks");
		listaCom2.add(restaurante1);
		listaCom2.add(restaurante2);
		
		GeradorEnquete gerador = new GeradorEnquete(listaCom2);
		List<Enquete> enquetes =  gerador.gerarLista();
	
		assertEquals(1, enquetes.size());
	}
	@Test
	public void deveGerarListaComQuantidadeCorretaDeCombinacoesCom3Restaurantes(){
		
		Set<Restaurante> listaCom3 = new HashSet<>();
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Outback");
		Restaurante restaurante2 = new Restaurante();
		restaurante1.setNome("Starbucks");
		Restaurante restaurante3 = new Restaurante();
		restaurante1.setNome("Big Kahuna Burger");		
		listaCom3.add(restaurante1);
		listaCom3.add(restaurante2);
		listaCom3.add(restaurante3);
		
		GeradorEnquete gerador = new GeradorEnquete(listaCom3);
		List<Enquete> enquetes =  gerador.gerarLista();
	
		assertEquals(3, enquetes.size());
	}		
	

}
