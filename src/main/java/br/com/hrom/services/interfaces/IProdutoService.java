package br.com.hrom.services.interfaces;

import java.util.List;

import br.com.hrom.exceptions.services.ProdutoJaExistenteException;
import br.com.hrom.modelo.entidades.Produto;

public interface IProdutoService {

	public abstract void cadastraProduto(Produto produto) throws ProdutoJaExistenteException;

	public abstract void atualizaCadastroProduto(Produto produto);

	public abstract Produto buscaProdutoPorId(long idProduto);

	public abstract List<Produto> buscaProdutoPorNome(String nome);

}