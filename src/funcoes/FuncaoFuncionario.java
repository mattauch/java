package funcoes;

import java.util.function.Function;

import dominio.Funcionario;

/*
 * Function é uma iterface funcional que permite chamar um construtor com 1 argumento
 */

public class FuncaoFuncionario implements Function<String, Funcionario>{
	
	//O método apply cria um objeto usando o construtor com um argumento
	@Override
	
	public Funcionario apply(String nome) {
		return new Funcionario(nome);
	}

}
