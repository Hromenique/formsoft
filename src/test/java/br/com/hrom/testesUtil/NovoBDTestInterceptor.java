package br.com.hrom.testesUtil;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * 
 * Classe Interceptor para criação de um novo banco de dados para testes
 * 
 * @author Hromenique Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Interceptor 
@NovoBancoDadosTest
public class NovoBDTestInterceptor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object criaNovoBancoDados(InvocationContext context) throws Exception{
		
		System.out.println("Novo Banco de Dados criado");		
		TestJPAUtil.criaBancoDadosVazio();			
		Object resultado = context.proceed();
		System.out.println("finalizando banco");
		
		return resultado;
	}

}
