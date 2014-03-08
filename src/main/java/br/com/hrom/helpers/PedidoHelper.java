package br.com.hrom.helpers;

import java.util.HashMap;
import java.util.Map;

import br.com.hrom.modelo.entidades.Comprador;
import br.com.hrom.modelo.entidades.ItemPedido;
import br.com.hrom.modelo.entidades.Pedido;
import br.com.hrom.modelo.entidades.Produto;

/**
 * 
 * Helper que auxiliar na construção de um objeto <b>Pedido</b>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class PedidoHelper {
	
	private Pedido pedido;	
	//Long = codigo do Produto (produto.codProduto)
	private Map<Long, ItemPedido> itensPedido;
	private Comprador comprador;
	
	
	public PedidoHelper(){
		this.pedido = new Pedido();
		this.itensPedido = new HashMap<Long, ItemPedido>();
	}	
	
	public void incluiProduto(Produto novoProduto, int quantidade){		
		
		ItemPedido itemPedido = itensPedido.get(novoProduto.getCodProduto());
		
		//produto NÃO incluso nos itens do pedido
		if(itemPedido == null){			
			//incluiNovoProdutoNoPedido(novoProduto, quantidade);
		}else{
			
		}	
		
	}
	
	public void incluiComprador(Comprador comprador){
		this.comprador = comprador;
	}
	
	public Pedido criaPedido(){
		return this.pedido;
	}
	
	/*
	private void incluiNovoProdutoNoPedido(Produto produto, int quantidade){
		ItemPedido novoItemPedido = new ItemPedido(produto, pedido, quantidade);
		this.itensPedido.put(produto.getCodProduto(), novoItemPedido);
	}*/
	
	private void aumentaQuantidadeItemPedido(ItemPedido item, int quantidadeParaSomar){
		int quantidadeAtualizada= item.getQuantidade() + quantidadeParaSomar;
		item.setQuantidade(quantidadeAtualizada);
	}
}































