package br.com.hrom.exceptions.services;

/**
 * 
 * Exce��o lan�ada no momento de inclus�o (salvamento) de um novo produto indicando a exist�ncia pr�via de um produto com o mesmo nome no banco de dados
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class ProdutoJaExistenteException extends Exception {

	public ProdutoJaExistenteException(String mensagem) {
		super(mensagem);
	}

}
