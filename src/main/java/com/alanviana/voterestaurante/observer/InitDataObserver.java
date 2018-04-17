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
			
			//1
			Restaurante restaurante = new Restaurante();
			restaurante.setNome("Feijoada");
			manager.persist(restaurante);
			//2
			restaurante = new Restaurante();
			restaurante.setNome("Virado Paulista");
			manager.persist(restaurante);
			//3
			restaurante = new Restaurante();
			restaurante.setNome("Pastel");
			manager.persist(restaurante);
			//4		
			restaurante = new Restaurante();
			restaurante.setNome("Coxinha");
			manager.persist(restaurante);
			//5
			restaurante = new Restaurante();
			restaurante.setNome("Lasanha");
			manager.persist(restaurante);
			//6
            restaurante = new Restaurante();
			restaurante.setNome("Pizza");
			manager.persist(restaurante);
			//7
			restaurante = new Restaurante();
			restaurante.setNome("Pão de Queijo");
			manager.persist(restaurante);
			//8
			restaurante = new Restaurante();
			restaurante.setNome("Bolinha de Queijo");
			manager.persist(restaurante);
			//9
			restaurante = new Restaurante();
			restaurante.setNome("Brigadeiro");
			manager.persist(restaurante);
			//10
			restaurante = new Restaurante();
			restaurante.setNome("Trufa");
			manager.persist(restaurante);
			//11
			restaurante = new Restaurante();
			restaurante.setNome("Bauru");
			manager.persist(restaurante);
			//12
			restaurante = new Restaurante();
			restaurante.setNome("Misto Quente");
			manager.persist(restaurante);
			//13
			restaurante = new Restaurante();
			restaurante.setNome("Acarajé");
			manager.persist(restaurante);
			//14
			restaurante = new Restaurante();
			restaurante.setNome("Bolinho de Bacalhau");
			manager.persist(restaurante);
			//15
			restaurante = new Restaurante();
			restaurante.setNome("Batata Frita");
			manager.persist(restaurante);
			//16
			restaurante = new Restaurante();
			restaurante.setNome("Mandioca Frita");
			manager.persist(restaurante);
			//17
			restaurante = new Restaurante();
			restaurante.setNome("Risoto");
			manager.persist(restaurante);
			//18
			restaurante = new Restaurante();
			restaurante.setNome("Arroz de Forno");
			manager.persist(restaurante);
			//19
			restaurante = new Restaurante();
			restaurante.setNome("Ovo Frito");
			manager.persist(restaurante);
			//20
			restaurante = new Restaurante();
			restaurante.setNome("Ovo Pochê");
			manager.persist(restaurante);
			//21
			restaurante = new Restaurante();
			restaurante.setNome("Bacon");
			manager.persist(restaurante);
			//22
			restaurante = new Restaurante();
			restaurante.setNome("Torresmo");
			manager.persist(restaurante);
			//23
			restaurante = new Restaurante();
			restaurante.setNome("Pudim");
			manager.persist(restaurante);
			//24
			restaurante = new Restaurante();
			restaurante.setNome("Pavê");
			manager.persist(restaurante);
			//25
			restaurante = new Restaurante();
			restaurante.setNome("Estrogonofe");
			manager.persist(restaurante);
			//26
			restaurante = new Restaurante();
			restaurante.setNome("Picadinho");
			manager.persist(restaurante);
			//27
			restaurante = new Restaurante();
			restaurante.setNome("Steak Tartare");
			manager.persist(restaurante);
			//28
			restaurante = new Restaurante();
			restaurante.setNome("Ceviche");
			manager.persist(restaurante);
			//29
			restaurante = new Restaurante();
			restaurante.setNome("Cachorro Quente");
			manager.persist(restaurante);
			//30
			restaurante = new Restaurante();
			restaurante.setNome("Buraco Quente");
			manager.persist(restaurante);
			//31
			restaurante = new Restaurante();
			restaurante.setNome("Bolo de Chocolate");
			manager.persist(restaurante);
			//32
			restaurante = new Restaurante();
			restaurante.setNome("Bolo de Cenoura");
			manager.persist(restaurante);
			
			
			manager.getTransaction().commit();			
		}finally{
			if (manager != null && manager.isOpen()) {
				manager.close();
			}
		}
		
	}
	
	
	
}
