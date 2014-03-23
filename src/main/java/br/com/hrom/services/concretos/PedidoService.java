package br.com.hrom.services.concretos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.hrom.dao.concretos.ProdutoEstoqueDAO;
import br.com.hrom.dao.interfaces.IPedidoDAO;
import br.com.hrom.dao.interfaces.IProdutoEstoqueDAO;
import br.com.hrom.modelo.entidades.ItemPedido;
import br.com.hrom.modelo.entidades.Pedido;
import br.com.hrom.services.interfaces.IPedidoService;
import br.com.hrom.utils.Transacional;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class PedidoService implements Serializable, IPedidoService{
	
	private static final long serialVersionUID = 1L;

	private IPedidoDAO pedidoDao;
	private IProdutoEstoqueDAO produtoEstoqueDao;
	
	@Inject
	public PedidoService(IPedidoDAO pedidoDAO, IProdutoEstoqueDAO produtoEstoqueDAO){
		this.pedidoDao = pedidoDAO;
		this.produtoEstoqueDao = produtoEstoqueDAO;
	}
	
	@Override
	@Transacional
	public void cadastraPedido(Pedido pedido) {
		pedidoDao.salva(pedido);		
	}
	
	public void validaPedido(List<ItemPedido> itens){
		List<ItemPedido> resultado;
		for(ItemPedido item : itens){
			
			produtoEstoqueDao.buscaProdutoEstoquePorLoteProduto(item.getProduto(), item.getLote());
			
		}
	}
}
