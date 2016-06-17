package com.alanviana.voterestaurante.controller;

import java.util.List;

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
public class IndexController {

	@Inject	private Result result;
	@Inject private RestauranteDAO restauranteDao;
	
	
	
	@Get("/")
	public void index(){
		List<Restaurante> restaurantes = restauranteDao.listAll();
		
		GeradorEnquete gerador = new GeradorEnquete(restaurantes);	
		List<Enquete> enquetes = gerador.gerar();
		
		result.use(Results.json()).withoutRoot().from(enquetes).serialize();
	}
	
}
