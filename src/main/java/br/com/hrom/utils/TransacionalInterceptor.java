package br.com.hrom.utils;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 * 
 * Interceptador que implementa transação JPA 2
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Interceptor
@Transacional
public class TransacionalInterceptor {
	
	@Inject
	EntityManager entityManager;
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		System.out.println("abrir transação");
		entityManager.getTransaction().begin();
		Object resultado = context.proceed();
		entityManager.getTransaction().commit();
		System.out.println("fechar transação");
		return resultado;
	}
}
