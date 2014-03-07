package br.com.hrom.services.concretos;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.hrom.dao.interfaces.IProdutoDAO;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.services.interfaces.IProdutoService;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 * 
 */

@RequestScoped
public class ProdutoService implements Serializable, IProdutoService {

	private static final long serialVersionUID = 1L;
	
	private IProdutoDAO dao;
	
	@Inject
	public ProdutoService(IProdutoDAO dao){
		this.dao = dao;
	}

	@Override
	public void cadastraProduto(Produto produto) {
		dao.salva(produto);
	}
	
	@Override
	public void atualizaCadastroProduto(Produto produto) {
		dao.atualiza(produto);
	}
	
	@Override
	public Produto buscaProdutoPorId(long idProduto) {
		
		Produto produto = dao.pesquisaPorId(idProduto);
		return produto;		
	}
	
	@Override
	public List<Produto> buscaProdutoPorNome(String nome) {
		List<Produto> produtos = dao.buscaProdutoPorNome(nome);
		return produtos;
	}
}
