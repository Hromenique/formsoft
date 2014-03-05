package br.com.hrom.testesIntegracao.bd;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.hrom.runner.WeldJUnit4Runner;
import br.com.hrom.testesUtil.NovoBancoDadosTest;

/**
 * 
 * Testa a criação do banco de dados.
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@RunWith(WeldJUnit4Runner.class)
public class CriaBDTest {	
	
	@Test
	@NovoBancoDadosTest
	public void criarBancoDados(){
		return;
	}
}
