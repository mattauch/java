package collectors;

import java.util.ArrayList;
import java.util.function.BiConsumer;

import dominio.Funcionario;

/*
 * ====>Adiciona apenas um objeto Funcionario a Cole��o
 * N�o retorna nada - Void, apenas adiciona
 * 
 * BiConsumer � uma interface funcional que cont�m o m�todo accept(),
 * que ser� invocado para adicionar cada elemento � lista passada
 */

public class Acumulador implements BiConsumer<ArrayList<Funcionario>, Funcionario>{

	@Override
	public void accept(ArrayList<Funcionario> lista, Funcionario f) {
	lista.add(f);
		
	}
	
	
}
