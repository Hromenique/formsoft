package br.com.hrom.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hrom.modelo.entidades.ItemPedido;
import br.com.hrom.modelo.entidades.Pedido;
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
public class CadastroPedidoMB implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private String produtoBuscado = "";	
	private Pedido pedidoEdicao;
	private ItemPedido itemPedidoEdicao;
	
	private Produto produtoSelecionado;
	private Produto produtoVisualizado;
	private ProdutoEstoque loteSelecionado;
	
	private List<Produto> produtos;
	private List<ProdutoEstoque> lotes;
	private List<ItemPedido> itensPedido;
	
	@Inject	
	private IProdutoService produtoService;
	@Inject
	private IProdutoEstoqueService produtoEstoqueService;
	
	public CadastroPedidoMB() {
		this.itensPedido = new ArrayList<ItemPedido>();		
		this.itemPedidoEdicao = new ItemPedido();
	}
	
	public void buscaProdutosPorNome(){		
		
		this.produtos = produtoService.buscaProdutosPorNome(this.produtoBuscado);	
		if(produtos.size() == 0){			
			ManagedBeanUtil.enviaMensagemAlerta(null, ManagedBeanUtil.getMensagemDoMessageBundle("produtosNaoEncontrados"), null);
		}
	}	
	
	public void buscaProdutoEstoque(){
		this.lotes = produtoEstoqueService.buscaProdutoEstoquePorProduto(this.produtoSelecionado);
	}
	
	public void incluirItemPedido(ActionEvent event){
		this.itemPedidoEdicao.setProdutoEstoque(this.loteSelecionado);
		this.itemPedidoEdicao.setPedido(this.pedidoEdicao);
		this.itensPedido.add(itemPedidoEdicao);
		
		this.itemPedidoEdicao = new ItemPedido();
		this.lotes = null;
		this.loteSelecionado = null;		
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
		return lotes;
	}
	public void setProdutoEstoques(List<ProdutoEstoque> produtoEstoques) {
		this.lotes = produtoEstoques;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public Produto getProdutoVisualizado() {
		return produtoVisualizado;
	}

	public void setProdutoVisualizado(Produto produtoVisualizado) {
		this.produtoVisualizado = produtoVisualizado;
	}

	public ProdutoEstoque getLoteSelecionado() {
		return loteSelecionado;
	}

	public void setLoteSelecionado(ProdutoEstoque loteSelecionado) {
		this.loteSelecionado = loteSelecionado;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public List<ProdutoEstoque> getLotes() {
		return lotes;
	}

	public void setLotes(List<ProdutoEstoque> lotes) {
		this.lotes = lotes;
	}

	public ItemPedido getItemPedidoEdicao() {
		return itemPedidoEdicao;
	}

	public void setItemPedidoEdicao(ItemPedido itemPedidoEdicao) {
		this.itemPedidoEdicao = itemPedidoEdicao;
	}
}
