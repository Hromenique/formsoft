package br.com.hrom.testesUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.interceptor.InterceptorBinding;

/**
 * 
 * Anotação para indicar a criação de um novo banco dados para testes
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@InterceptorBinding
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface NovoBancoDadosTest {

}
