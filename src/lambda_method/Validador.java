package lambda_method;
/*
 * Aqiu criamos nossa pr�pria interface funcional
 * Podemos marcar uma interface funcional explicidamente, mas isso � opcional
 * por�m se uma interface for anotada e adicionarmos mais um m�todo, ocorre um erro de compila��o
 */

@FunctionalInterface
public interface Validador<T> { //tipo gen�rico
	
	//interface com um �nico m�todo = interface funcional
	boolean validar(T t);

}
