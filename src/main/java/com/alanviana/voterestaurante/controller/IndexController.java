package com.alanviana.voterestaurante.controller;

import java.util.List;

import javax.inject.Inject;

import com.alanviana.voterestaurante.dao.RestauranteDAO;
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
		List<Restaurante> lista = restauranteDao.listAll();
		
		result.use(Results.http()).body("quantidade:"+lista.size());
		
		//result.use(Results.json()).from(lista);
	}
	
}
