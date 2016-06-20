package com.alanviana.voterestaurante.dao;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.alanviana.voterestaurante.model.Restaurante;


@Default
public class DefaultVotoDAO implements VotoDAO {

	private final EntityManager entityManager;
	
	/**
	 * @deprecated CDI eyes only
	 */
	protected DefaultVotoDAO() {
		this(null);
	}
	
	@Inject
	public DefaultVotoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public HashMap<Restaurante, Integer> contarTodosAgrupandoPorRestaurante() {
		
		HashMap<Restaurante, Integer> contagem = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createQuery("SELECT r.id AS id, (SELECT COUNT(v) FROM Voto as v WHERE v.restaurante.id = r.id) AS total "
														   + "FROM Restaurante AS r ").getResultList();		
		for (Object[] result : results) {
		    Integer id = (Integer) result[0];
		    int count = ((Number) result[1]).intValue();
		    
		    Restaurante restaurante = new Restaurante();
		    restaurante.setId(id);
		    
		    contagem.put(restaurante, count);
		}
		
		return contagem;
	}	
	
	
}
