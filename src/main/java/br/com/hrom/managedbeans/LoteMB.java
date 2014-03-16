package br.com.hrom.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.hrom.exceptions.services.ProdutoEstoqueInvalidoException;
import br.com.hrom.modelo.entidades.Produto;
import br.com.hrom.modelo.entidades.ProdutoEstoque;
import br.com.hrom.services.interfaces.IProdutoEstoqueService;
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
public class LoteMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomeProduto = "";
	private ProdutoEstoque prodEstoqueEdicao;
	private Produto produtoSelecionado;
	private List<Produto> produtos;
	
	@Inject
	private IProdutoService produtoService;
	
	@Inject
	private IProdutoEstoqueService produtoEstoqueService;
	
	public LoteMB(){
		this.prodEstoqueEdicao = new ProdutoEstoque();
		this.produtos = new ArrayList<Produto>();
	}
	
	public void buscaProdutosPorNome(){
		this.produtos = produtoService.buscaProdutosPorNome(this.nomeProduto);	
		if(produtos.size() == 0){
			ManagedBeanUtil.enviaMensagemAlerta("sem_produto", ManagedBeanUtil.getMensagemDoMessageBundle("produtosNaoEncontrados"), null);
		}
	}
	
	public void cadastraLoteProduto(){
		this.prodEstoqueEdicao.setProduto(this.produtoSelecionado);	
		
		try {
			produtoEstoqueService.cadastraProdutoEstoque(this.produtoSelecionado, this.prodEstoqueEdicao);
		} 
		catch (ProdutoEstoqueInvalidoException exception) {
			ProdutoEstoque prodEstoqueCadastrado = exception.getProdutoEstoqueCadastrado();
			String validade = (prodEstoqueCadastrado.getValidade() == null) ? null : ManagedBeanUtil.formataData(prodEstoqueCadastrado.getValidade()) ;
			String fabricacao = (prodEstoqueCadastrado.getFabricacao() == null) ? null : ManagedBeanUtil.formataData(prodEstoqueCadastrado.getFabricacao());
			String mensagem = ManagedBeanUtil.getMensagemDoMessageBundle("loteInvalido", fabricacao, validade);
			
			ManagedBeanUtil.enviaMensagemErro(null, mensagem, null);			
		}	
	}
	
	public boolean getExisteProdutos(){
		boolean resultado = (this.produtos == null) ? false : (this.produtos.size() > 0);
		System.out.println(resultado);
		return resultado;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public ProdutoEstoque getProdEstoqueEdicao() {
		return prodEstoqueEdicao;
	}

	public void setProdEstoqueEdicao(ProdutoEstoque prodEstoqueEdicao) {
		this.prodEstoqueEdicao = prodEstoqueEdicao;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
