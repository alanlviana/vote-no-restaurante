package com.alanviana.voterestaurante.controller;

import java.util.HashMap;

import javax.inject.Inject;

import com.alanviana.voterestaurante.dao.VotoDAO;
import com.alanviana.voterestaurante.model.Restaurante;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class RakingController {

		@Inject private Result result;
		@Inject private VotoDAO dao;
		
		@Get("/raking")
		public void raking(){
			HashMap<Restaurante, Integer> contagem = dao.contarTodosAgrupandoPorRestaurante();
			
			result.use(Results.json()).from(contagem).recursive().serialize();
		}
	
}
