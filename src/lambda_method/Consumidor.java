package lambda_method;

import java.util.function.Consumer;

import dominio.Funcionario;

/*
 * O que é uma Interface Funcional?
 * Qualquer interface que possua um único método abstrato é chamado de interface funcional
 * Obs: métodos marcados com a palavra reservada default, são métodos especiais e são implementados
 * dentro de interfaces, por isso não contam como métodos abstratos.
 */

/*
 * Aqui temos a interface funcional Consumer que implementa um único método abstrato: accept();
 */
public class Consumidor implements Consumer<Funcionario> {

	@Override
	public void accept(Funcionario p) {
		System.out.println(p);
		
	}

}
