package br.com.hrom.utils;

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
public class TransacionalInterceptor {
	
	@Inject
	EntityManager entityManager;
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		System.out.println("abrir transa��o");
		entityManager.getTransaction().begin();
		Object resultado = context.proceed();
		entityManager.getTransaction().commit();
		System.out.println("fechar transa��o");
		return resultado;
	}
}
