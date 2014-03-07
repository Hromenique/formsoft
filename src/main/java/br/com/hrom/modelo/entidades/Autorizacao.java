package br.com.hrom.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Entity
@SequenceGenerator(name = "autorizacao_sequence", sequenceName = "autorizacao_sequence", initialValue = 1, allocationSize = 1)
public class Autorizacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cod_autorizacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="autorizacao_sequence")
	private long codAutorizacaoo;
	
	@Column(nullable = false)
	private String role;
	
	@ManyToMany
	@JoinTable(
			name = "usuarios_autorizacoes", 
			joinColumns = {@JoinColumn(name="cod_usuario", foreignKey = @ForeignKey(name="usuarios_autorizacoes_usuario_fkey"))}, 
			inverseJoinColumns={@JoinColumn(name="cod_autorizacao", foreignKey = @ForeignKey(name="autorizacao_usuarios_autorizacoes_fkey"))})	
	private List<Usuario> usuarios;
	
	public Autorizacao(){
		
	}

	public long getCod_autorizacao() {
		return codAutorizacaoo;
	}

	public void setCod_autorizacao(long cod_autorizacao) {
		this.codAutorizacaoo = cod_autorizacao;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
