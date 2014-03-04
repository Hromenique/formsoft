package br.com.hrom.runner;


import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;


/**
 *  
 * Classe "Runner" para execução de testes automatizados (JUnit) que dependam do CDI (injeção de dependência)<br/>
 * <b>Fonte:</b>> <a href= "http://www.mews.com.br/dev/java/cdi-weld-testes-unitarios" >http://www.mews.com.br/dev/java/cdi-weld-testes-unitarios</a>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {
	
	
	private final Class klass;
    private final Weld weld;
    private final WeldContainer container;
    
    public WeldJUnit4Runner(final Class klass) throws InitializationError {
        super(klass);
        this.klass = klass;
        this.weld = new Weld();
        this.container = weld.initialize();
    }
    
    @Override
    protected Object createTest() throws Exception {
        final Object test = container.instance().select(klass).get();
 
        return test;
    }
}
