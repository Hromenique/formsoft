package br.com.hrom.modelo.pk;

import java.io.Serializable;

/**
 * 
 * Chave primária da tabela <b>item_pedido</b>, que é representada pela classe <b>ItemPedido</b>
 * 
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class PedidoProdutoEstoquePK implements Serializable{

	private static final long serialVersionUID = 1L;
	private long pedido;
	private long produtoEstoque;
	
	public PedidoProdutoEstoquePK(){
		
	}

	public long getPedido() {
		return pedido;
	}

	public void setPedido(long pedido) {
		this.pedido = pedido;
	}

	public long getProduto() {
		return produtoEstoque;
	}

	public void setProduto(long produto) {
		this.produtoEstoque = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (pedido ^ (pedido >>> 32));
		result = prime * result + (int) (produtoEstoque ^ (produtoEstoque >>> 32));
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
		PedidoProdutoEstoquePK other = (PedidoProdutoEstoquePK) obj;
		if (pedido != other.pedido)
			return false;
		if (produtoEstoque != other.produtoEstoque)
			return false;
		return true;
	}
}
