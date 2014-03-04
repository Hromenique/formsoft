package br.com.hrom.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * 
 * Representa uma descrição de um produto em estoque. Um produto pode ter entradas distintas no estoque. 
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Entity
@Table(name = "produto_estoque", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"cod_produto", "lote" }) })
@SequenceGenerator(name = "produto_estoque_sequence", sequenceName = "produto_estoque_sequence", initialValue = 1, allocationSize = 1)
public class ProdutoEstoque implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="produto_estoque_sequence")
	@Column(name="cod_produto_estoque")
	private long codProdutoEstoque;	
	
	@Column(nullable=false)
	private int lote;	
	
	@OneToOne(optional=false)
    @JoinColumn(name = "cod_produto")
	private Produto produto;
	
	@Column(name="quant_inicial", nullable=false, updatable=false)
	private int quantidadeInicial;
	
	@Column(name="quant_atual", nullable=false)
	private int quantidadeAtual;		
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fabricacao", nullable=false)
	private Date fabricacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validade", nullable=false)
	private Date validade;
	
	@Column(nullable=false, scale=2)
	private double preco;
	
	public ProdutoEstoque(){
		
	}

	public long getCodProdutoEstoque() {
		return codProdutoEstoque;
	}

	public void setCodProdutoEstoque(long codProdutoEstoque) {
		this.codProdutoEstoque = codProdutoEstoque;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public Date getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (codProdutoEstoque ^ (codProdutoEstoque >>> 32));
		result = prime * result
				+ ((fabricacao == null) ? 0 : fabricacao.hashCode());
		result = prime * result + lote;
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + quantidadeAtual;
		result = prime * result + quantidadeInicial;
		result = prime * result
				+ ((validade == null) ? 0 : validade.hashCode());
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
		if (fabricacao == null) {
			if (other.fabricacao != null)
				return false;
		} else if (!fabricacao.equals(other.fabricacao))
			return false;
		if (lote != other.lote)
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
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
		if (validade == null) {
			if (other.validade != null)
				return false;
		} else if (!validade.equals(other.validade))
			return false;
		return true;
	}
	


}
