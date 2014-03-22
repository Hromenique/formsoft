package br.com.hrom.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hrom.modelo.entidades.Pedido;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;
import br.com.hrom.services.interfaces.IProdutoService;
import br.com.hrom.utils.ManagedBeanUtil;

@Named
@SessionScoped
public class CadastroPedidoMB implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private String produtoBuscado="";	
	private Pedido pedidoEdicao;
	
	private Produto produtoSelecionado;
	
	private List<Produto> produtos;
	private List<ProdutoEstoque> produtoEstoques;
	
	@Inject	
	private IProdutoService produtoService;
	
	public void buscaProdutosPorNome(){		
		
		this.produtos = produtoService.buscaProdutosPorNome(this.produtoBuscado);	
		if(produtos.size() == 0){			
			ManagedBeanUtil.enviaMensagemAlerta(null, ManagedBeanUtil.getMensagemDoMessageBundle("produtosNaoEncontrados"), null);
		}
	}	
	
	public String getProdutoBuscado() {
		return produtoBuscado;
	}
	public void setProdutoBuscado(String produtoBuscado) {
		this.produtoBuscado = produtoBuscado;
	}
	public Pedido getPedidoEdicao() {
		return pedidoEdicao;
	}
	public void setPedidoEdicao(Pedido pedidoEdicao) {
		this.pedidoEdicao = pedidoEdicao;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<ProdutoEstoque> getProdutoEstoques() {
		return produtoEstoques;
	}
	public void setProdutoEstoques(List<ProdutoEstoque> produtoEstoques) {
		this.produtoEstoques = produtoEstoques;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}
