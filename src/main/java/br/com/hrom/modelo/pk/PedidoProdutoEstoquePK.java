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
public class PedidoProdutoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	private long pedido;
	private long produto;
	
	public PedidoProdutoPK(){
		
	}

	public long getPedido() {
		return pedido;
	}

	public void setPedido(long pedido) {
		this.pedido = pedido;
	}

	public long getProduto() {
		return produto;
	}

	public void setProduto(long produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (pedido ^ (pedido >>> 32));
		result = prime * result + (int) (produto ^ (produto >>> 32));
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
		PedidoProdutoPK other = (PedidoProdutoPK) obj;
		if (pedido != other.pedido)
			return false;
		if (produto != other.produto)
			return false;
		return true;
	}
}
