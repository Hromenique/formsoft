package br.com.hrom.exceptions.services;

import br.com.hrom.modelo.entidades.ProdutoEstoque;

/**
 * 
 * Exce��o lan�ada no momento da inclus�o de um novo ProdutoEstoque no banco de dados. Indica que j� existe  um ProdutoEstoque pr�vio no banco de dados com o mesmo lote, 
 * mas com data de validade e/ou fabrica��o diferentes do objeto que estamos tentando  persistir
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class ProdutoEstoqueInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private ProdutoEstoque produtoEstoqueCadastradoNoBD;
	
	public ProdutoEstoqueInvalidoException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutoEstoqueInvalidoException(String mensagem, ProdutoEstoque produtoEstoqueCadastradoNoBD){
		super(mensagem);
		this.produtoEstoqueCadastradoNoBD = produtoEstoqueCadastradoNoBD;
	}	

	public ProdutoEstoque getProdutoEstoqueCadastrado() {
		return produtoEstoqueCadastradoNoBD;
	}

}
