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
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 * 
 */

@Entity
@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence", initialValue = 1, allocationSize = 1)
@Table(uniqueConstraints = {@UniqueConstraint(name = "login_uk", columnNames = { "login" })})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario_sequence")
	private long codUsuario;
	
	@Column(nullable=false, length=50)
	private String nome;
	
	@Column(nullable=false, length=50)
	private String login;
	
	@Column(nullable=false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean ativo;
	
	public Usuario(){
		
	}

	public Usuario(long codUsuario, String nome, String login, boolean ativo) {
		super();
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.login = login;
		this.ativo = ativo;
	}

	public long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + (int) (codUsuario ^ (codUsuario >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (codUsuario != other.codUsuario)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
