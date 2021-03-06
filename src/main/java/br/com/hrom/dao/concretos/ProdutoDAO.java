package br.com.hrom.dao.concretos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.hrom.dao.abstracts.AbstractGenericDAO;
import br.com.hrom.dao.interfaces.IProdutoDAO;
import br.com.hrom.modelo.entidades.Produto;

/**
 * 
 * DAO concreto para a entidade Produto
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public class ProdutoDAO extends AbstractGenericDAO<Produto> implements IProdutoDAO{

	private static final long serialVersionUID = 1L;

	@Inject
	public ProdutoDAO(EntityManager entityManager) {
		super(entityManager);		
	}	
	
	@Override
	public List<Produto> buscaProdutosPorNome(String nomeProduto) {		
		String sql = "SELECT produto FROM Produto produto WHERE LOWER(produto.nome) LIKE ?0";
		TypedQuery<Produto> query = getEntityManager().createQuery(sql, Produto.class);
		List<Produto> resultList = query.setParameter(0, "%"+nomeProduto.toLowerCase()+"%").getResultList();		
		
		return resultList;
	}

	@Override
	public Produto buscaProdutoPorNome(String nomeProduto) {		
		String sql = "SELECT produto FROM Produto produto WHERE LOWER(produto.nome) = ?0";
		List<Produto> produtos = getEntityManager().createQuery(sql, Produto.class).setParameter(0, nomeProduto.toLowerCase()).getResultList();
		
		return (produtos.size() > 0) ? produtos.get(0) : null;
	}
}



