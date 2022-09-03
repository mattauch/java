package collectors;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

import dominio.Funcionario;

/*
 * classe java.util.Optional
 * Foi criada para evitar verifica��es de extremos (de null por exemplo)
 * cont�m vers�es primitivas: OptionalInt, OptionalLong, OptinalDoube
 */

public class ExemploOptional {

		public static void main(String[] args) {
			List<Funcionario> funcionarios = List.of(
					new Funcionario(1, "Jo�o", 16),
					new Funcionario(2, "Angelita", 27),
					new Funcionario(3, "Antonio", 39),
					new Funcionario(4, "Aparecida", 55));
			
		//Objetivo: calcular a m�dia das idades
			OptionalDouble media = funcionarios.stream() //fluxo de dados
							.mapToInt(Funcionario::getIdade)
							.average();

			System.out.println(media.orElse(0.0)); // devolve a m�dia ou zero
			
			//ou podemos lan�ar uma excess�o se o valor dor 0.0
			double valorMedia = funcionarios.stream()
											.mapToInt(Funcionario::getIdade)
											.average()
											.orElseThrow(IllegalStateException::new);
			
			System.out.println(valorMedia);
			
			//ou podemos verificar se existe um valor dentro do Optional
			funcionarios.stream() //fluxo de dados
							.mapToInt(Funcionario::getIdade)
							.average()
							.ifPresent(System.out::println); // s� imprime se existir valor
			
			//Obt�m o funcion�rio mais novo
			funcionarios.stream()
							.min(Comparator.comparing(Funcionario::getIdade))
							.ifPresent(f -> System.out.printf("\nIdade do funcion�rio mais novo: %d", f.getIdade()));
							
			//Obt�m idade do funcion�rio mais velho
							funcionarios.stream()
							.max(Comparator.comparing(Funcionario::getIdade))
							.ifPresent(f -> System.out.printf("\nIdade do funcion�rio mais velho: %d", f.getIdade()));
							
							
			
			
	}

}
