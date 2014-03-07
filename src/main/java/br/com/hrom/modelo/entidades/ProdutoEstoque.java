package br.com.hrom.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Entity
@Table(name = "produto_estoque")
@SequenceGenerator(name = "prod_estoque_sequence", sequenceName = "prod_estoque_sequence", initialValue = 1, allocationSize = 1)
public class ProdutoEstoque implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name = "cod_prod_estoque")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prod_estoque_sequence")
	private long codProdutoEstoque;
	
	@Column(name="quant_inicial",nullable=false)
	private int quantidadeInicial;
	
	@Column(name="quant_atual",nullable=false, updatable=false)
	private int quantidadeAtual;
	
	@Column(name="quant_minima", nullable=false)
	private int quantidadeMinima;
	
	@ManyToOne
	@JoinColumn(name="cod_produto")
	private Produto produto;

	public long getCodProdutoEstoque() {
		return codProdutoEstoque;
	}

	public void setCodProdutoEstoque(long codProdutoEstoque) {
		this.codProdutoEstoque = codProdutoEstoque;
	}

	public int getQuantidadeInicial() {
		return quantidadeInicial;
	}

	public void setQuantidadeInicial(int quantidadeInicial) {
		this.quantidadeInicial = quantidadeInicial;
	}

	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (codProdutoEstoque ^ (codProdutoEstoque >>> 32));
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantidadeAtual;
		result = prime * result + quantidadeInicial;
		result = prime * result + quantidadeMinima;
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
		ProdutoEstoque other = (ProdutoEstoque) obj;
		if (codProdutoEstoque != other.codProdutoEstoque)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidadeAtual != other.quantidadeAtual)
			return false;
		if (quantidadeInicial != other.quantidadeInicial)
			return false;
		if (quantidadeMinima != other.quantidadeMinima)
			return false;
		return true;
	}
}
