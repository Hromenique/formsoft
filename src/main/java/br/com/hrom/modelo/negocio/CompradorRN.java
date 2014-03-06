package br.com.hrom.modelo.negocio;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.hrom.dao.concretos.CompradorDAO;
import br.com.hrom.modelo.entidades.Comprador;

/**
 * 
 * Mant�m as regras de neg�cio relacionado a um comprador
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@RequestScoped
public class CompradorRN {
	
	@Inject
	private CompradorDAO dao;
	
	public void cadastraComprador(Comprador comprador){
		dao.salva(comprador);
	}
	
	public void atualizaComprador(Comprador comprador){
		dao.atualiza(comprador);
	}
}
