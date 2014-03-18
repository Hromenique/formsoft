package br.com.hrom.dao.interfaces;

import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public interface IProdutoEstoqueDAO extends GenericDAO<ProdutoEstoque>{	

	public ProdutoEstoque buscaProdutoEstoque(Produto produto, String lote);
}
