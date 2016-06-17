package com.alanviana.voterestaurante.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alanviana.voterestaurante.model.Restaurante;

@Default
@RequestScoped
public class DefaultRestauranteDAO implements RestauranteDAO{

	private final EntityManager entityManager;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected DefaultRestauranteDAO() {
		this(null);
	}
	
	@Inject
	public DefaultRestauranteDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
	
	@Override
	public void add(Restaurante restaurante) {
		entityManager.persist(restaurante);
	}

	@Override
	public List<Restaurante> listAll() {
		return entityManager.createQuery("select r from Restaurante  r", Restaurante.class).getResultList();
	}

}
