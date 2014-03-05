package br.com.hrom.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * Representa um Produto. Esta classe se relaciona com a tabela <b>produto</b> do banco de dados
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Entity
@SequenceGenerator(name = "produto_sequence", sequenceName = "produto_sequence", initialValue = 1, allocationSize = 1)
@Table(uniqueConstraints={@UniqueConstraint(name = "nome_uk", columnNames = { "nome" })})
public class Produto implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="produto_sequence")
	@Column(name="cod_produto")
	private long codProduto;
	
	@Column(nullable=false, length=40)	
	private  String nome;	
	
	@Column(nullable=true, length=250)
	private String descricao;
	
	@Column(nullable=true, length=40)
	private String fabricante;
	
	@Column(name="quant_inicial",nullable=false)
	private int quantidadeInicial;
	
	@Column(name="quant_atual",nullable=false, updatable=false)
	private int quantidadeAtual;
	
	@Column(name="quant_minima", nullable=false)
	private int quantidadeMinima;
	
	public Produto(){		
		
	}		

	public Produto(long codProduto, String nome, String descricao,
			String fabricante, int quantidadeInicial, int quantidadeAtual,
			int quantidadeMinima) {
		super();
		this.codProduto = codProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.quantidadeInicial = quantidadeInicial;
		this.quantidadeAtual = quantidadeAtual;
		this.quantidadeMinima = quantidadeMinima;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codProduto ^ (codProduto >>> 32));
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Produto other = (Produto) obj;
		if (codProduto != other.codProduto)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
