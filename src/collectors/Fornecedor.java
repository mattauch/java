package collectors;

import java.util.ArrayList;
import java.util.function.Supplier;

import dominio.Funcionario;

/*
 *Conceito Factory
 *O que é um factory?
 *É um Design Pattern (padrão de projetos)
 *é uma fábrica de objetos, ou seja, uma classe com um método que instancia e retorna determinado objeto
 *
 *Supplier cria um objeto através do construtor padrão do objeto (sem argumentos)
 *Supplier é uma interface funcional com um único método: get();
 */

//Devolve um ArrayList de Funcionário
public class Fornecedor implements Supplier<ArrayList<Funcionario>>{

	@Override
	public ArrayList<Funcionario> get() {
		return new ArrayList<Funcionario>();
	}

	
	
}
