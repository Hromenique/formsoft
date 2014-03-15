package br.com.hrom.exceptions.services;

/**
 * 
 * Exceção lançada no momento de inclusão (salvamento) de um novo produto indicando a existência prévia de um produto com o mesmo nome no banco de dados
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
