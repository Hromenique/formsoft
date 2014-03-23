package br.com.hrom.dao.interfaces;

import java.util.List;

import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public interface IProdutoEstoqueDAO extends GenericDAO<ProdutoEstoque>{	

	public List<ProdutoEstoque> buscaProdutoEstoquePorProduto(Produto produto);

	public List<ProdutoEstoque> buscaProdutoEstoquePorLoteProduto(Produto produto, String lote);	
}
