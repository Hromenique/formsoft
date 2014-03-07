package br.com.hrom.dao.concretos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hrom.dao.abstracts.AbstractGenericDAO;
import br.com.hrom.dao.interfaces.IPedidoDAO;
import br.com.hrom.modelo.entidades.Pedido;


/**
 * 
 * DAO Concreto para a entidade Pedido
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class PedidoDAO extends AbstractGenericDAO<Pedido> implements IPedidoDAO {

	private static final long serialVersionUID = 1L;

	@Inject
	public PedidoDAO(EntityManager entityManager) {
		super(entityManager);		
	}

}
