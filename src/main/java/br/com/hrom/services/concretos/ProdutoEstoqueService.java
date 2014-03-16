package br.com.hrom.services.concretos;

import java.io.Serializable;
import javax.inject.Inject;

import br.com.hrom.dao.interfaces.IProdutoEstoqueDAO;
import br.com.hrom.exceptions.services.ProdutoEstoqueInvalidoException;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;
import br.com.hrom.services.interfaces.IProdutoEstoqueService;
import br.com.hrom.utils.Transacional;

/**
 * 
 * Classe que mantém as regras de negócio que envolve a entidade ProdutoEstoque
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
	public void cadastraProdutoEstoque(Produto produto, ProdutoEstoque produtoEstoque) throws ProdutoEstoqueInvalidoException {
		
		ProdutoEstoque produtoEstoqueCadastradoNoBD = dao.buscaProdutoEstoque(produto, produtoEstoque.getLote());
		if (produtoEstoqueCadastradoNoBD != null) {
			if (!comparaIgualdadeProdutoEstoque(produtoEstoque,	produtoEstoqueCadastradoNoBD)) {
				throw new ProdutoEstoqueInvalidoException("Objeto ProdutoEstoque inválido. ProdutoEstoque's com o mesmo lote devem possuir a mesma fabricacao e validade", produtoEstoqueCadastradoNoBD);
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
