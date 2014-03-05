package br.com.hrom.testesIntegracao;

//import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * 
 * Testa a criação do banco de dados.
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class CriaBDTest {	
	
	@Test
	public void criarBancoDados(){
		//Persistence.createEntityManagerFactory("formsoft_bd_pu");
		//<property name="hibernate.hbm2ddl.auto" value="create" />
		
		Map<String, String> properties = new HashMap<String, String>()	;
		properties.put("hibernate.hbm2ddl.auto", "create");		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("formsoft_bd_pu", properties);
		
		//criou o Banco de Dados
		return;
	}
}
