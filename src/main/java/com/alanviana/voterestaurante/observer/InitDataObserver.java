package com.alanviana.voterestaurante.observer;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.alanviana.voterestaurante.model.Restaurante;

import br.com.caelum.vraptor.events.VRaptorInitialized;

@Dependent
public class InitDataObserver {

	private final EntityManagerFactory factory;

	
	@Inject
	public InitDataObserver(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	public void insert(@Observes VRaptorInitialized event){
		
		EntityManager manager = factory.createEntityManager();
		
		try{
			manager.getTransaction().begin();
			
			Restaurante restaurante = new Restaurante();
			restaurante.setNome("Outback");
			manager.persist(restaurante);
			
			restaurante = new Restaurante();
			restaurante.setNome("The Fifties");
			manager.persist(restaurante);
			
			restaurante = new Restaurante();
			restaurante.setNome("Big Kahuna Burger");
			manager.persist(restaurante);
						
			restaurante = new Restaurante();
			restaurante.setNome("Rock'n'Roll Burger");
			manager.persist(restaurante);
			
			restaurante = new Restaurante();
			restaurante.setNome("Spock Burger");
			manager.persist(restaurante);
			
			manager.getTransaction().commit();			
		}finally{
			if (manager != null && manager.isOpen()) {
				manager.close();
			}
		}
		
	}
	
	
	
}
