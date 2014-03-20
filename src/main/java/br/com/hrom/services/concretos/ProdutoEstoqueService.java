package br.com.hrom.services.concretos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.hrom.dao.interfaces.IProdutoEstoqueDAO;
import br.com.hrom.exceptions.services.ProdutoEstoqueInvalidoException;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;
import br.com.hrom.services.interfaces.IProdutoEstoqueService;
import br.com.hrom.utils.Transacional;

/**
 * 
 * Classe que mant�m as regras de neg�cio que envolve a entidade ProdutoEstoque
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public class ProdutoEstoqueService implements Serializable, IProdutoEstoqueService {

	private static final long serialVersionUID = 1L;
	
	private IProdutoEstoqueDAO dao;
	
	@Inject
	public ProdutoEstoqueService(IProdutoEstoqueDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transacional
	public void cadastraProdutoEstoque(ProdutoEstoque produtoEstoque) throws ProdutoEstoqueInvalidoException {
		
		List<ProdutoEstoque> produtosEstoqueDoBD = dao.buscaProdutoEstoquePorLote(produtoEstoque.getProduto(), produtoEstoque.getLote());
		
		// Se o lote j� existe no BD, verificar se � um lote v�lido
		if (produtosEstoqueDoBD != null) {
			if (!comparaIgualdadeProdutoEstoque(produtoEstoque,	produtosEstoqueDoBD.get(0))) {
				throw new ProdutoEstoqueInvalidoException("Objeto ProdutoEstoque inv�lido. ProdutoEstoque's com o mesmo lote devem possuir a mesma fabricacao e validade", produtosEstoqueDoBD.get(0));
			}
		}
		
		dao.salva(produtoEstoque);	
	}		

	private boolean comparaIgualdadeProdutoEstoque(ProdutoEstoque a, ProdutoEstoque b){
		if( (a.getLote() == b.getLote()) && (a.getFabricacao() == b.getFabricacao()) && (a.getValidade() == b.getValidade()) ){
			return true;
		}
		
		return false;		
	}
}
