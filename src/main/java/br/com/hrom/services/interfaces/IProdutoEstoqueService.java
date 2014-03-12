package br.com.hrom.services.interfaces;

import java.util.List;

import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;


/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public interface IProdutoEstoqueService {
	
	void cadastraProdutoEstoque(ProdutoEstoque produtoEstoque);
	List<ProdutoEstoque> buscaProdutoEstoquePorProduto(Produto produto);
	
	

}
