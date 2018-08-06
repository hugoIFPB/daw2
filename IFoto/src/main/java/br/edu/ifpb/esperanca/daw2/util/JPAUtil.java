package br.edu.ifpb.esperanca.daw2.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifoto_pu");

	@Produces
	@RequestScoped
	public EntityManager criarEM() {
		return emf.createEntityManager();
	}

	public void fecharEM(@Disposes EntityManager em) {
		em.close();
	}

}
