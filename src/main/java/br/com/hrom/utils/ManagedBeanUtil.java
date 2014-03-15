package br.com.hrom.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe que possui métodos para auxílio dos Managed Beans
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */
public class ManagedBeanUtil {

	public static void enviaMensagemInfo(String destino, String sumario, String descricao){
		enviaMensagem(FacesMessage.SEVERITY_INFO, destino, sumario, descricao );
	}
	
	public static String getMensagemDoMessageBundle(String chave){
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");		
		return bundle.getString(chave);			
	}
	
	public static String getMensagemDoMessageBundle(String chave, Object... parametros){
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
		String mensagem = bundle.getString(chave);
		return MessageFormat.format(mensagem, parametros);		
	}
	
	public static void enviaMensagemErro(String destino, String sumario, String descricao){
		enviaMensagem(FacesMessage.SEVERITY_ERROR, destino, sumario, descricao );
	}

	public static void enviaMensagemAlerta(String destino, String sumario, String descricao){
		enviaMensagem(FacesMessage.SEVERITY_WARN, destino, sumario, descricao );
	}

	public static void enviaMensagemFatal(String destino, String sumario, String descricao){
		enviaMensagem(FacesMessage.SEVERITY_FATAL, destino, sumario, descricao );
	}
	
	
	private static void enviaMensagem(FacesMessage.Severity severidade,String destino, String sumario, String descricao ){
		FacesContext.getCurrentInstance().addMessage(destino, new FacesMessage(severidade, sumario, descricao));
	}		
}
