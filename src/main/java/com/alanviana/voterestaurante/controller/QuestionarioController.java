package com.alanviana.voterestaurante.controller;

import java.security.InvalidParameterException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import com.alanviana.voterestaurante.dao.QuestionarioDAO;
import com.alanviana.voterestaurante.model.Questionario;
import com.alanviana.voterestaurante.model.QuestionarioSessao;
import com.alanviana.voterestaurante.model.Restaurante;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class QuestionarioController {
	
	@Inject private Result result;
	@Inject private QuestionarioDAO dao;
	@Inject private QuestionarioSessao sessao;
	

	@Post("/questionario")
	public void cadastrar(String nome, String email, List<Restaurante> restaurantes){
		
		Questionario questionario;
		
		try{
			questionario = new Questionario(nome, email, restaurantes);
		}catch(InvalidParameterException exception){
			result.use(Results.http()).setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			result.use(Results.json()).from(exception.getMessage(), "message").serialize();
			return;
		}
		
		try{
			dao.add(questionario);
			sessao.setQuestionario(questionario);
			
			result.use(Results.http()).setStatusCode(HttpServletResponse.SC_CREATED);
		}catch(Exception exception){
			result.use(Results.http()).setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			result.use(Results.json()).from(exception.getMessage(), "message").serialize();
			return;
				
		}
	}


}
