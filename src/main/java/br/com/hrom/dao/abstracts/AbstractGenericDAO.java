package br.com.hrom.dao.abstracts;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.hrom.dao.interfaces.GenericDAO;

/**
 * 
 * Classe abstrata que implementa um <b>GenericDAO</b>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 * @param <T>
 */
public class AbstractGenericDAO<T> implements GenericDAO<T> {

	private EntityManager entityManager;
	private Class<T> classePersistida;
	
	public AbstractGenericDAO() {
		this.classePersistida = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T pesquisaPorId(Object id) {			
		T entidade = entityManager.find(classePersistida, id);
		return entidade;
	}

	@Override
	public List<T> listaTodos() {
		String entidade = this.classePersistida.getSimpleName();
		String sql = "SELECT entidade FROM " + entidade + "entidade";
		
		TypedQuery<T> query = entityManager.createQuery(sql, classePersistida);
		 List<T> resultList = query.getResultList();
		
		return resultList;		
	}

	@Override
	public void salva(T entidade) {
		entityManager.persist(entidade);		
	}

	@Override
	public void atualiza(T entidade) {
		entityManager.merge(entidade);		
	}
}
