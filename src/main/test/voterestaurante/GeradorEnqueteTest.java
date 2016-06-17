package voterestaurante;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.alanviana.voterestaurante.model.Enquete;
import com.alanviana.voterestaurante.model.GeradorEnquete;
import com.alanviana.voterestaurante.model.Restaurante;

public class GeradorEnqueteTest {
	
	private List<Restaurante> restaurantes;
	
	@Before
	public void setup(){
		restaurantes = new ArrayList<>();
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
		List<Restaurante> lista = new ArrayList<>();
		new GeradorEnquete(lista);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void deveRecusarListaNula(){
		new GeradorEnquete(null);
	}
	
	@Test
	public void deveGerarListaComEnquetes(){
		GeradorEnquete gerador = new GeradorEnquete(restaurantes);
		List<Enquete> enquetes =  gerador.gerar();
	
		assertNotNull(enquetes);
	}
	
	@Test
	public void deveGerarListaComQuantidadeCorretaDeCombinacoes(){
		GeradorEnquete gerador = new GeradorEnquete(restaurantes);
		List<Enquete> enquetes =  gerador.gerar();
	
		assertEquals(10, enquetes.size());
	
	}

}
