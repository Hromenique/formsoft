package br.com.hrom.modelo.negocio;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.hrom.dao.concretos.ProdutoDAO;
import br.com.hrom.modelo.entidades.Produto;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 * 
 */

@RequestScoped
public class ProdutoRN implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoDAO dao;

	public void cadastraProduto(Produto produto) {
		dao.salva(produto);
	}

	public void atualizaCadastroProduto(Produto produto) {
		dao.atualiza(produto);
	}

	public Produto buscaProdutoPorId(long idProduto) {
		
		Produto produto = dao.pesquisaPorId(idProduto);
		return produto;		
	}

	public List<Produto> buscaProdutoPorNome(String nome) {
		List<Produto> produtos = dao.buscaProdutoPorNome(nome);
		return produtos;
	}
}
