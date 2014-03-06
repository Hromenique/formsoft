package br.com.hrom.dao.interfaces;

import java.util.List;

import br.com.hrom.modelo.entidades.Produto;

/**
 * 
 * Interface de um DAO genérico para Produto
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public interface IProdutoDAO extends GenericDAO<Produto>{
	
	List<Produto> buscaProdutoPorNome(String nomeProduto);

}
