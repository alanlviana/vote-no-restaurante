package com.alanviana.voterestaurante.dao;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.alanviana.voterestaurante.model.GeradorRanking;
import com.alanviana.voterestaurante.model.PosicaoRanking;
import com.alanviana.voterestaurante.model.Questionario;
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
	public List<PosicaoRanking> contarTodosAgrupandoPorRestaurante() {

		@SuppressWarnings("unchecked")
		List<Object[]> results = entityManager.createQuery(
				"SELECT r, (SELECT COUNT(v) FROM Voto as v WHERE v.restaurante.id = r.id) AS total "
						+ "FROM Restaurante AS r ")
				.getResultList();

		GeradorRanking gerador = new GeradorRanking();
		for (Object[] result : results) {
			Restaurante restaurante = (Restaurante) result[0];
			int count = ((Number) result[1]).intValue();

			gerador.adicionarRestaurante(restaurante, count);
		}

		return gerador.gerarListaPosicoes();
	}

	@Override
	public List<PosicaoRanking> contarTodosAgrupandoPorRestauranteFiltrandoPorQuestionario(Questionario questionario) {
		Query query = entityManager.createQuery(
				"SELECT r , (SELECT COUNT(v) FROM Voto as v WHERE v.restaurante.id = r.id AND v.questionario = :questionario) AS total "
						+ "FROM Restaurante AS r ");
	    query.setParameter("questionario", questionario);
	    
	    @SuppressWarnings("unchecked")
		List<Object[]> results =	query.getResultList();

		GeradorRanking gerador = new GeradorRanking();
		for (Object[] result : results) {
			Restaurante restaurante = (Restaurante) result[0];
			int count = ((Number) result[1]).intValue();

			gerador.adicionarRestaurante(restaurante, count);
		}

		return gerador.gerarListaPosicoes();
	}

}
