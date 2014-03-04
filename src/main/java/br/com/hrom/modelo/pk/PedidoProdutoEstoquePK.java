package br.com.hrom.modelo.pk;

import java.io.Serializable;

/**
 * 
 * Classe que representa a chave composta da classe <b>ItemProduto</b>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public class PedidoProdutoEstoquePK implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private int pedido;
	private int produtoEstoque;
	
	public PedidoProdutoEstoquePK(){
		
	}

	public int getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(int produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pedido;
		result = prime * result + produtoEstoque;
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
