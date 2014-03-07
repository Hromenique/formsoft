package br.com.hrom.services.concretos;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.hrom.dao.concretos.CompradorDAO;
import br.com.hrom.modelo.entidades.Comprador;

/**
 * 
 * Mantém as regras de negócio relacionado a um comprador
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@RequestScoped
public class CompradorService implements ICompradorService, Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CompradorDAO dao;
	
	@Override
	public void cadastraComprador(Comprador comprador){
		dao.salva(comprador);
	}	
	
	@Override
	public void atualizaComprador(Comprador comprador){
		dao.atualiza(comprador);
	}
}
