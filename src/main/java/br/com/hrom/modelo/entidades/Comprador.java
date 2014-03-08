package br.com.hrom.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * Classe que representa um comprador e mantém informações da tabela <b>comprador</b>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Entity
@SequenceGenerator(name = "comprador_sequence", sequenceName = "comprador_sequence", initialValue = 1, allocationSize = 1)
public class Comprador implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	enum TipoPessoa{Fisica, Juridica}
	
	@Id
	@Column(name="cod_comprador")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="comprador_sequence")
	private long codComprador;
	
	@Column(nullable=false, length=50)
	private String nome;
	
	@Column(nullable=false, length=200)
	private String endereco;
	
	@Column(name="cpf_cnpj", nullable=false, length=14)
	private String cpfCnpj;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_pessoa", nullable=false)
	private TipoPessoa tipoPessoa;
	
	public Comprador(){
		
	}	

	public Comprador(long codComprador, String nome, String endereco,
			String cpfCnpj, TipoPessoa tipoPessoa) {
		super();
		this.codComprador = codComprador;
		this.nome = nome;
		this.endereco = endereco;
		this.cpfCnpj = cpfCnpj;
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(Comprador.TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public long getCodComprador() {
		return codComprador;
	}

	public void setCodComprador(long codComprador) {
		this.codComprador = codComprador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codComprador ^ (codComprador >>> 32));
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
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
		Comprador other = (Comprador) obj;
		if (codComprador != other.codComprador)
			return false;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoPessoa != other.tipoPessoa)
			return false;
		return true;
	}

}
