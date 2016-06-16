package com.alanviana.voterestaurante.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class IndexController {

	@Inject private Result result;
	
	public void index(){
		result.use(Results.http()).body("oi").setStatusCode(200);
	}
	
}
