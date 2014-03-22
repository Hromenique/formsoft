package br.com.hrom.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Classe que representa um item do pedido.
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Entity
@Table(name="item_pedido")
@IdClass(br.com.hrom.modelo.pk.PedidoProdutoEstoquePK.class)
public class ItemPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@Id
    @ManyToOne(optional=false)
    @JoinColumn(name = "cod_pedido", foreignKey= @ForeignKey(name = "item_pedido_pedido_fkey"))
	private Pedido pedido;
	
	@Id
    @ManyToOne(optional=false)
    @JoinColumn(name = "cod_produto_estoque", foreignKey= @ForeignKey(name = "item_pedido_produto_estoque_fkey"))
	private ProdutoEstoque produtoEstoque;	
	
	@Column(nullable=false)	
	private int quantidade;		
	
	public ItemPedido(){
		
	}

	public ItemPedido(Pedido pedido, ProdutoEstoque produtoEstoque,
			int quantidade) {
		super();
		this.pedido = pedido;
		this.produtoEstoque = produtoEstoque;
		this.quantidade = quantidade;
	}
	
	public String getLote(){
		return this.produtoEstoque.getLote();
	}
	
	public Produto getProduto(){
		return this.produtoEstoque.getProduto();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ProdutoEstoque getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(ProdutoEstoque produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result
				+ ((produtoEstoque == null) ? 0 : produtoEstoque.hashCode());
		result = prime * result + quantidade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produtoEstoque == null) {
			if (other.produtoEstoque != null)
				return false;
		} else if (!produtoEstoque.equals(other.produtoEstoque))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}	
}
