package br.com.hrom.testesUtil;

import java.util.HashMap;
import java.util.Map;

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
		Map<String, String> properties = new HashMap<String, String>()	;
		properties.put("hibernate.hbm2ddl.auto", "create");		
		Persistence.createEntityManagerFactory("formsoft_bd_pu", properties);
	}
}
