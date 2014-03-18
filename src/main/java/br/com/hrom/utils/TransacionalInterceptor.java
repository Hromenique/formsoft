package br.com.hrom.utils;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 * 
 * Interceptador que implementa transa��o JPA 2
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Interceptor
@Transacional
public class TransacionalInterceptor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager entityManager;
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		Object resultado = null;				
		
		try{
			System.out.println("abrir transa��o");	
			entityManager.getTransaction().begin();
			
			resultado = context.proceed();
			
			System.out.println("fechar transa��o");
			entityManager.getTransaction().commit();
		}
		catch(Exception exception){			
			if (entityManager.getTransaction().isActive()) {
				System.out.println("rollback da transa��o");
				entityManager.getTransaction().rollback();
			}
			
			throw exception;			
		}		
		
		return resultado;
	}
}
