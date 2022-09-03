package lambda_method;
/*
 * Aqiu criamos nossa própria interface funcional
 * Podemos marcar uma interface funcional explicidamente, mas isso é opcional
 * porém se uma interface for anotada e adicionarmos mais um método, ocorre um erro de compilação
 */

@FunctionalInterface
public interface Validador<T> { //tipo genérico
	
	//interface com um único método = interface funcional
	boolean validar(T t);

}
