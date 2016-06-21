package com.alanviana.voterestaurante.model;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class QuestionarioSessao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7227207568306359585L;
	
	private Questionario questionario;
	
	public QuestionarioSessao(){
		questionario = null;
	}
	
	public void setQuestionario(Questionario questionario){
		this.questionario = questionario;
	}
	
	public boolean temQuestionario(){
		return questionario != null;
	}
	
	public Questionario getQuestionario(){
		return this.questionario;
	}
}
