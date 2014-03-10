package br.com.hrom.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * Classe que contém métodos que auxiliam nas funcionalidades providas pelo framework JPA 2
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public class JPAUtil {
	
	@Produces @ApplicationScoped
	public EntityManagerFactory criaEntityManagerFactory(){		
		return Persistence.createEntityManagerFactory("formsoft_bd_pu");
	}
	
	@Produces @RequestScoped
	public EntityManager criaEntityManager(EntityManagerFactory entityManagerFactory){			
		return entityManagerFactory.createEntityManager();			
	}	
	
	public void fechaEntityManager(@Disposes EntityManager entityManager){
		entityManager.close();
	}
}
