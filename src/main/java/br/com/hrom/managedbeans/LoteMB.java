package br.com.hrom.managedbeans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;
import br.com.hrom.services.interfaces.IProdutoEstoqueService;
import br.com.hrom.services.interfaces.IProdutoService;
import br.com.hrom.utils.ManagedBeanUtil;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Named
public class LoteMB {
	
	private String nomeProduto;
	private ProdutoEstoque prodEstoque;
	private Produto produtoSelecionado;
	private List<Produto> produtos;
	
	
	private IProdutoService produtoService;
	
	
	private IProdutoEstoqueService produtoEstoqueService;
	
	public LoteMB(){
		
	}
	
	public void buscaProdutoPorNome(){
		this.produtos = produtoService.buscaProdutoPorNome(this.nomeProduto);		
	}
	
	public void selecionaProdutoNaLista(){
		
	}
	
	public void cadastraLoteProduto(){
		this.prodEstoque.setProduto(this.produtoSelecionado);		
		produtoEstoqueService.cadastraProdutoEstoque(this.prodEstoque);	
		ManagedBeanUtil.enviaMensagemInfo(null, "Lote cadastrado com sucesso!", null);
		iniciaCampos();
	}

	private void iniciaCampos() {
		this.prodEstoque = new ProdutoEstoque();
		this.nomeProduto = "";
		this.produtoSelecionado = null;
		this.produtos = null;		
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public ProdutoEstoque getProdEstoque() {
		return prodEstoque;
	}

	public void setProdEstoque(ProdutoEstoque prodEstoque) {
		this.prodEstoque = prodEstoque;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
