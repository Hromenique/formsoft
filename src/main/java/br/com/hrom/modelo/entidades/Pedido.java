package br.com.hrom.modelo.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Representa um pedido feito. Mantém as informações da tabela <b>Pedido</b>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 * 
 */

@Entity
@SequenceGenerator(name = "pedido_sequence", sequenceName = "pedido_sequence", initialValue = 1, allocationSize = 1)
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pedido_sequence")
	@Column(name = "cod_pedido")
	private long codPedido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_compra", nullable = false)
	private Date dataCompra;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_entrega", nullable = true)
	private Date dataEntrega;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cod_comprador", foreignKey = @ForeignKey(name="pedido_comprador_fkey"))
	private Comprador comprador;

	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itensPedido;

	public Pedido() {
		this.itensPedido = new ArrayList<ItemPedido>();
	}
	
	public void incluiProduto(Produto produto, int quantidade) {		
		int indiceItemPedido = this.itensPedido.indexOf(produto);
		
		if(indiceItemPedido != -1){
			aumentaQuantidadeItemPedido(this.itensPedido.get(indiceItemPedido), quantidade);
		}else{
			incluiNovoProdutoNoPedido(produto, quantidade);
		}
	}
	
	private void incluiNovoProdutoNoPedido(Produto produto, int quantidade){
		ItemPedido novoItemPedido = new ItemPedido(produto, this, quantidade);
		this.itensPedido.add(novoItemPedido);
	}
	
	private void aumentaQuantidadeItemPedido(ItemPedido item, int quantidadeParaSomar){
		int quantidadeAtualizada= item.getQuantidade() + quantidadeParaSomar;
		item.setQuantidade(quantidadeAtualizada);
	}

	public long getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(long codPedido) {
		this.codPedido = codPedido;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codPedido ^ (codPedido >>> 32));
		result = prime * result
				+ ((comprador == null) ? 0 : comprador.hashCode());
		result = prime * result
				+ ((dataCompra == null) ? 0 : dataCompra.hashCode());
		result = prime * result
				+ ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
		result = prime * result
				+ ((itensPedido == null) ? 0 : itensPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (codPedido != other.codPedido)
			return false;
		if (comprador == null) {
			if (other.comprador != null)
				return false;
		} else if (!comprador.equals(other.comprador))
			return false;
		if (dataCompra == null) {
			if (other.dataCompra != null)
				return false;
		} else if (!dataCompra.equals(other.dataCompra))
			return false;
		if (dataEntrega == null) {
			if (other.dataEntrega != null)
				return false;
		} else if (!dataEntrega.equals(other.dataEntrega))
			return false;
		if (itensPedido == null) {
			if (other.itensPedido != null)
				return false;
		} else if (!itensPedido.equals(other.itensPedido))
			return false;
		return true;
	}
}
