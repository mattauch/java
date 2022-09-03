package collectors;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

import dominio.Funcionario;

/*
 * classe java.util.Optional
 * Foi criada para evitar verificações de extremos (de null por exemplo)
 * contém versões primitivas: OptionalInt, OptionalLong, OptinalDoube
 */

public class ExemploOptional {

		public static void main(String[] args) {
			List<Funcionario> funcionarios = List.of(
					new Funcionario(1, "João", 16),
					new Funcionario(2, "Angelita", 27),
					new Funcionario(3, "Antonio", 39),
					new Funcionario(4, "Aparecida", 55));
			
		//Objetivo: calcular a média das idades
			OptionalDouble media = funcionarios.stream() //fluxo de dados
							.mapToInt(Funcionario::getIdade)
							.average();

			System.out.println(media.orElse(0.0)); // devolve a média ou zero
			
			//ou podemos lançar uma excessão se o valor dor 0.0
			double valorMedia = funcionarios.stream()
											.mapToInt(Funcionario::getIdade)
											.average()
											.orElseThrow(IllegalStateException::new);
			
			System.out.println(valorMedia);
			
			//ou podemos verificar se existe um valor dentro do Optional
			funcionarios.stream() //fluxo de dados
							.mapToInt(Funcionario::getIdade)
							.average()
							.ifPresent(System.out::println); // só imprime se existir valor
			
			//Obtém o funcionário mais novo
			funcionarios.stream()
							.min(Comparator.comparing(Funcionario::getIdade))
							.ifPresent(f -> System.out.printf("\nIdade do funcionário mais novo: %d", f.getIdade()));
							
			//Obtém idade do funcionário mais velho
							funcionarios.stream()
							.max(Comparator.comparing(Funcionario::getIdade))
							.ifPresent(f -> System.out.printf("\nIdade do funcionário mais velho: %d", f.getIdade()));
							
							
			
			
	}

}
