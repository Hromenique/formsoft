package br.com.hrom.managedbeans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hrom.exceptions.services.ProdutoJaExistenteException;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.services.interfaces.IProdutoService;
import br.com.hrom.utils.ManagedBeanUtil;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@Named
@RequestScoped
public class CadastroProdutoMB implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	@Inject
	private IProdutoService service;
	
	public CadastroProdutoMB(){
		this.produto = new Produto();
	}
	
	public void cadastra(ActionEvent event){		
		
		try {
			service.cadastraProduto(this.produto);
		} catch (ProdutoJaExistenteException e) {
			String mensagemErro = ManagedBeanUtil.getMensagemDoMessageBundle("produtoJaExistente", this.produto.getNome());
			ManagedBeanUtil.enviaMensagemErro(null, mensagemErro, null);
			e.printStackTrace();
			return; //manter valores na tela
		}		
		
		ManagedBeanUtil.enviaMensagemInfo(null, ManagedBeanUtil.getMensagemDoMessageBundle("produtoAdicionado"), null);
		this.produto = new Produto();		
	}	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
