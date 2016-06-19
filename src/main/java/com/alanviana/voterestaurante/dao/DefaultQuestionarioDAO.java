package com.alanviana.voterestaurante.dao;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alanviana.voterestaurante.model.Questionario;
import com.alanviana.voterestaurante.model.Voto;

@Default
public class DefaultQuestionarioDAO implements QuestionarioDAO {

	
	private final EntityManager entityManager;

	/**
	 * @deprecated CDI eyes only
	 */
	protected DefaultQuestionarioDAO() {
		this(null);
	}
	
	@Inject
	public DefaultQuestionarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}		
	
	@Override
	public void add(Questionario questionario) {
		entityManager.persist(questionario);
		
		for(Voto voto : questionario.getVotos()){
			entityManager.persist(voto);
		}
		
	}

}
