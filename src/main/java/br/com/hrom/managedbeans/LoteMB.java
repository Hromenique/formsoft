package br.com.hrom.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hrom.exceptions.services.ProdutoEstoqueInvalidoException;
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
@SessionScoped
public class LoteMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomeProduto = "";
	private ProdutoEstoque prodEstoqueEdicao;
	private Produto produtoSelecionado;
	private Produto produtoVisualizado;
	private List<Produto> produtos;
	
	@Inject
	private IProdutoService produtoService;
	
	@Inject
	private IProdutoEstoqueService produtoEstoqueService;
	
	public LoteMB(){
		this.prodEstoqueEdicao = new ProdutoEstoque();		
	}
	
	public void buscaProdutosPorNome(){
		//Nova busca, deselecionar o produto
		this.produtoSelecionado = null;
		
		this.produtos = produtoService.buscaProdutosPorNome(this.nomeProduto);	
		if(produtos.size() == 0){			
			ManagedBeanUtil.enviaMensagemAlerta(null, ManagedBeanUtil.getMensagemDoMessageBundle("produtosNaoEncontrados"), null);
		}
	}
	
	public void cadastraLoteProduto(ActionEvent event){
		
		if(!dataValidadeValida()){
			ManagedBeanUtil.enviaMensagemErro(null, ManagedBeanUtil.getMensagemDoMessageBundle("validadeInvalida"), null);
			return;
		}		
		
		this.prodEstoqueEdicao.setProduto(this.produtoSelecionado);	
		
		try {
			produtoEstoqueService.cadastraProdutoEstoque(this.produtoSelecionado, this.prodEstoqueEdicao);
		} 
		catch (ProdutoEstoqueInvalidoException exception) {
			ProdutoEstoque prodEstoqueCadastrado = exception.getProdutoEstoqueCadastrado();
			String validade = (prodEstoqueCadastrado.getValidade() == null) ? null : ManagedBeanUtil.formataData(prodEstoqueCadastrado.getValidade()) ;
			String fabricacao = (prodEstoqueCadastrado.getFabricacao() == null) ? null : ManagedBeanUtil.formataData(prodEstoqueCadastrado.getFabricacao());		
			
			ManagedBeanUtil.enviaMensagemErro(null, ManagedBeanUtil.getMensagemDoMessageBundle("loteInvalido", fabricacao, validade), null);			
		}	
	}
	
	/**
	public boolean getProdutosNaoPopulado(){
		return (this.produtos == null) ? true : (this.produtos.size() == 0);
	}*/

	private boolean dataValidadeValida() {
		if (this.prodEstoqueEdicao.getValidade() != null) {
			if (this.prodEstoqueEdicao.getValidade().compareTo(this.prodEstoqueEdicao.getFabricacao()) <= 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public ProdutoEstoque getProdEstoqueEdicao() {
		return prodEstoqueEdicao;
	}

	public void setProdEstoqueEdicao(ProdutoEstoque prodEstoqueEdicao) {
		this.prodEstoqueEdicao = prodEstoqueEdicao;
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

	public Produto getProdutoVisualizado() {
		return produtoVisualizado;
	}

	public void setProdutoVisualizado(Produto produtoVisualizado) {
		this.produtoVisualizado = produtoVisualizado;
	}
}
