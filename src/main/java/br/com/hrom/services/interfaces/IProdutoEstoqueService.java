package br.com.hrom.services.interfaces;

import java.util.List;

import br.com.hrom.exceptions.services.ProdutoEstoqueInvalidoException;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;


/**
 * 
 * Interface que mantém os serviços comuns para entidade ProdutoEstoque
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public interface IProdutoEstoqueService {

	void cadastraProdutoEstoque(ProdutoEstoque produtoEstoque)throws ProdutoEstoqueInvalidoException;	
	List<ProdutoEstoque> buscaProdutoEstoquePorProduto(Produto produto);
}
