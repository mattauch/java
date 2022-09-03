package predicado;

import java.util.function.Predicate;

import dominio.Funcionario;

/*
 * A interface funcional Predicate possui um único método abstrato test() que retorna um boolean
 * possui os métodos default: and, or, negate, isEqual, not
 * Um Predicado sempre retorna verdadeiro ou falso
 */

public class PredicadoFuncionario implements Predicate<Funcionario>{
	
	@Override
	public boolean test(Funcionario f) {
		return f.getIdade() >= 18;
	}
	
}
