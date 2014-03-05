package br.com.hrom.utils;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * 
 * Anotação indicando uma transação JPA 2
 * 
 * @author Hromenique Cezniowscki Leite Batista
 * @version 1.0
 *
 */

@InterceptorBinding
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Transacional {

}
