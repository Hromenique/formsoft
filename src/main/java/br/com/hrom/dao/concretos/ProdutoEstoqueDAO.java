package br.com.hrom.dao.concretos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hrom.dao.abstracts.AbstractGenericDAO;
import br.com.hrom.dao.interfaces.IProdutoEstoqueDAO;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class ProdutoEstoqueDAO extends AbstractGenericDAO<ProdutoEstoque> implements IProdutoEstoqueDAO {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public ProdutoEstoqueDAO(EntityManager entityManager) {
		super(entityManager);		
	}
	
	@Override
	public List<ProdutoEstoque> buscaProdutoEstoquePorLoteProduto(Produto produto, String lote) {
		String sql = "SELECT produtoLote FROM ProdutoEstoque produtoLote WHERE produtoLote.lote = ?0 AND produtoLote.produto = ?1";
		List<ProdutoEstoque> resultList = getEntityManager().createQuery(sql, ProdutoEstoque.class).setParameter(0, lote).setParameter(1, produto).getResultList();

		return (resultList.size() > 0) ? resultList : null;
	}

	@Override
	public List<ProdutoEstoque> buscaProdutoEstoquePorProduto(Produto produto) {
		String sql = "SELECT produtoLote FROM ProdutoEstoque produtoLote WHERE produtoLote.produto = ?0";
		List<ProdutoEstoque> resultList = getEntityManager().createQuery(sql, ProdutoEstoque.class).setParameter(0, produto).getResultList();
				
		return (resultList.size() > 0) ? resultList : null;
	}


}
