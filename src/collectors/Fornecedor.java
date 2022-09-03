package collectors;

import java.util.ArrayList;
import java.util.function.Supplier;

import dominio.Funcionario;

/*
 *Conceito Factory
 *O que � um factory?
 *� um Design Pattern (padr�o de projetos)
 *� uma f�brica de objetos, ou seja, uma classe com um m�todo que instancia e retorna determinado objeto
 *
 *Supplier cria um objeto atrav�s do construtor padr�o do objeto (sem argumentos)
 *Supplier � uma interface funcional com um �nico m�todo: get();
 */

//Devolve um ArrayList de Funcion�rio
public class Fornecedor implements Supplier<ArrayList<Funcionario>>{

	@Override
	public ArrayList<Funcionario> get() {
		return new ArrayList<Funcionario>();
	}

	
	
}
