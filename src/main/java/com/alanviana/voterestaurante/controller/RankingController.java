package com.alanviana.voterestaurante.controller;

import java.util.List;

import javax.inject.Inject;

import com.alanviana.voterestaurante.dao.VotoDAO;
import com.alanviana.voterestaurante.model.PosicaoRanking;
import com.alanviana.voterestaurante.model.QuestionarioSessao;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class RankingController {

		@Inject private Result result;
		@Inject private VotoDAO dao;
		@Inject private QuestionarioSessao sessao;
		
		@Get("/ranking")
		public void ranking(){
			
			
			List<PosicaoRanking> contagemGlobal = dao.contarTodosAgrupandoPorRestaurante();
			List<PosicaoRanking> contagemUsuario = null;
			if (sessao.temQuestionario()){
				contagemUsuario = dao.contarTodosAgrupandoPorRestauranteFiltrandoPorQuestionario(sessao.getQuestionario());
			}
			
			result.include("rankingGlobal", contagemGlobal);
			result.include("rankingUsuario", contagemUsuario);
			
		}
	
	
}
