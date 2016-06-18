package com.alanviana.voterestaurante.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import com.alanviana.voterestaurante.dao.RestauranteDAO;
import com.alanviana.voterestaurante.model.Enquete;
import com.alanviana.voterestaurante.model.GeradorEnquete;
import com.alanviana.voterestaurante.model.Restaurante;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class EnqueteController {

	@Inject
	private Result result;
	@Inject
	private RestauranteDAO restauranteDao;

	
	@Get("/enquete")
	public void index() {
		List<Restaurante> restaurantes = restauranteDao.listAll();
		// Cria um set com os resturantes
		Set<Restaurante> listaRestaurante = new HashSet<>(restaurantes);
		GeradorEnquete gerador = new GeradorEnquete(listaRestaurante);
		List<Enquete> enquetes = gerador.gerar();

		result.use(Results.json()).withoutRoot().from(enquetes).recursive().serialize();
	}
}
