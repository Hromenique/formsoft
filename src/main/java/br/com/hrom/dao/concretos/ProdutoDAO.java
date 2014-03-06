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
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public class ProdutoDAO extends AbstractGenericDAO<Produto> implements IProdutoDAO{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<Produto> buscaProdutoPorNome(String nomeProduto) {
		String nomeBuscado = "%"+nomeProduto+"%";
		String sql = "SELECT produto FROM Produto produto WHERE produto.nome LIKE %?1%";
		TypedQuery<Produto> query = entityManager.createQuery(sql, Produto.class);
		List<Produto> resultList = query.setParameter(0, nomeBuscado).getResultList();		
		
		return resultList;
	}
}



