package br.com.hrom.dao.interfaces;

import java.util.List;

/**
 * 
 * Interface de um DAO genérico (Data Acess Object) que apresenta as operações comuns executadas por qualquer DAO do sistema
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 * @param <T> Classe que representa a entidade alvo do DAO
 */

public interface GenericDAO <T>{
	
	T pesquisaPorId(Object id);
	List<T> listaTodos();
	void salva(T entidade);
	void atualiza(T entidade);
}
