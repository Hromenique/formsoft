package br.com.hrom.services.interfaces;

import br.com.hrom.modelo.entidades.Comprador;

public interface ICompradorService {

	public abstract void cadastraComprador(Comprador comprador);

	public abstract void atualizaComprador(Comprador comprador);

}