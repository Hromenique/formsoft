package br.com.hrom.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Classe que representa um item do pedido. Contém informações do pedido e do produto saído do estoque
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
	@OneToOne(optional=false)
    @JoinColumn(name = "cod_produto_estoque")
	private ProdutoEstoque produtoEstoque;
	
	@Id
    @OneToOne(optional=false)
    @JoinColumn(name = "cod_pedido")
	private Pedido pedido;
	
	@Column(nullable=false)	
	private int quantidade;	
	
	public ItemPedido(){
		
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoEstoque getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(ProdutoEstoque produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
