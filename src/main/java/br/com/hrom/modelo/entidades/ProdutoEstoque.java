package br.com.hrom.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Entity
@Table(name="produto_estoque")
@SequenceGenerator(name = "prod_estoque_sequence", sequenceName = "prod_estoque_sequence", initialValue = 1, allocationSize = 1)
public class ProdutoEstoque implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id	
	@Column(name = "cod_prod_estoque")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prod_estoque_sequence")
	private long codProdutoEstoque;	
	
	@Column(nullable = false)
	private int lote;	
	
	@Column(name="quant_inicial",nullable=false)
	private int quantidadeInicial;
	
	@Column(name="quant_atual",nullable=false, updatable=false)
	private int quantidadeAtual;	

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fabricacao;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date validade;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inclusao", nullable = false)
	private Date dataInclusao;
	
	@ManyToOne
	@JoinColumn(name="cod_produto", nullable = false, foreignKey= @ForeignKey(name = "produto_estoque_produto_fkey"))
	private Produto produto;	
	
	public ProdutoEstoque(){
		
	}

	public ProdutoEstoque(long codProdutoEstoque, int lote,
			int quantidadeInicial, int quantidadeAtual, Date fabricacao,
			Date validade, Date dataInclusao, Produto produto) {
		super();
		this.codProdutoEstoque = codProdutoEstoque;
		this.lote = lote;
		this.quantidadeInicial = quantidadeInicial;
		this.quantidadeAtual = quantidadeAtual;
		this.fabricacao = fabricacao;
		this.validade = validade;
		this.dataInclusao = dataInclusao;
		this.produto = produto;
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

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
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
		result = prime * result
				+ ((dataInclusao == null) ? 0 : dataInclusao.hashCode());
		result = prime * result
				+ ((fabricacao == null) ? 0 : fabricacao.hashCode());
		result = prime * result + lote;
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
		if (dataInclusao == null) {
			if (other.dataInclusao != null)
				return false;
		} else if (!dataInclusao.equals(other.dataInclusao))
			return false;
		if (fabricacao == null) {
			if (other.fabricacao != null)
				return false;
		} else if (!fabricacao.equals(other.fabricacao))
			return false;
		if (lote != other.lote)
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
