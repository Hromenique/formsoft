package br.com.hrom.testesIntegracao.bd;

import org.junit.Test;
import br.com.hrom.testesUtil.TestJPAUtil;

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
		TestJPAUtil.criaBancoDadosVazio();
	}
}
