package com.alanviana.voterestaurante.controller;

import java.util.List;

import com.alanviana.voterestaurante.model.Restaurante;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class QuestionarioController {
	
	@Get("/questionario")
	public void cadastrar(String nome, String email, List<Restaurante> restaurantes){
		
	}	

}
