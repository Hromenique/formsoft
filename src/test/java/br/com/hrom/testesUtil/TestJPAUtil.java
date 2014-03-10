package br.com.hrom.testesUtil;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * Classe que contém métodos auxiliares para o framework JPA 2 para testes
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public class TestJPAUtil {
	
	public static void criaBancoDadosVazio(){
		System.out.println("Inciando criação banco de dados");
		
		Map<String, String> properties = new HashMap<String, String>()	;
		properties.put("hibernate.hbm2ddl.auto", "create");		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("formsoft_bd_pu", properties);
		factory.close();
		
		System.out.println("Banco de dados criado");
	}	
}
