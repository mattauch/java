package collectors;

import java.util.ArrayList;
import java.util.function.BiConsumer;

import dominio.Funcionario;

/*
 * ====>Adiciona vários objetos à coleção: junta 2 listas
 */

public class Combinador implements BiConsumer<ArrayList<Funcionario>, ArrayList<Funcionario>> {

	@Override
	public void accept(ArrayList<Funcionario> lista1, ArrayList<Funcionario> lista2) {
		lista1.addAll(lista2);
		
	}

}
