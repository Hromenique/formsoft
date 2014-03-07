package br.com.hrom.dao.concretos;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.hrom.dao.abstracts.AbstractGenericDAO;
import br.com.hrom.dao.interfaces.ICompradorDAO;
import br.com.hrom.modelo.entidades.Comprador;

/**
 * 
 * DAO concreto para a entidade Comprador
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class CompradorDAO extends AbstractGenericDAO<Comprador> implements ICompradorDAO{

	private static final long serialVersionUID = 1L;

	@Inject
	public CompradorDAO(EntityManager entityManager) {
		super(entityManager);		
	}

}
