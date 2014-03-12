package br.com.hrom.dao.concretos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hrom.dao.abstracts.AbstractGenericDAO;
import br.com.hrom.dao.interfaces.IProdutoEstoqueDAO;
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


}
