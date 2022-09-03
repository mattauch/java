package collectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import dominio.Funcionario;

/*
 * Um Collector converte Stream em Collection, chamando o método collect() do Stream
 * Collector é a junção de várias interfaces funcionais como: Supplier, Function, BiFunction, etc
 */

public class ExemploCollector {

	public static void main(String[] args) {
		List<Funcionario> funcionarios = List.of(new Funcionario(1, "João", 16), new Funcionario(2, "Angelita", 27),
				new Funcionario(3, "Antonio", 39), new Funcionario(4, "Aparecida", 55));
		// Fornecedor é uma factory da classe Funcionario (fábrica de funcionários)
		Supplier<ArrayList<Funcionario>> fornecedor = ArrayList::new; // method reference

		// Acumulador serve para adicionar cada elemento na coleção
		BiConsumer<ArrayList<Funcionario>, Funcionario> acumulador = ArrayList::add;

		// Combinador serve para adicionar mais de um elemento ao mesmo tempo
		BiConsumer<ArrayList<Funcionario>, ArrayList<Funcionario>> combinador = ArrayList::addAll;

		// Stream permite fazer concatenação = pipeline (encanamento)
		List<Funcionario> maisDe30 = funcionarios.stream().filter(f -> f.getIdade() > 30).collect(fornecedor,
				acumulador, combinador);

		maisDe30.forEach(System.out::println);

		// ficou complicado, então vamos simplificar
		System.out.println("\nCollector simplificado devolvendo List");
		funcionarios.stream()
					.filter(f -> f.getIdade() > 30)	
					.collect(Collectors.toList()) //devolve um collector parecido com o de cima
					.forEach(System.out::println);
		
		//também podemos devolver um set com o Collector
		System.out.println("\n\nCollector devolvendo um Set");
		funcionarios.stream()
						.filter(f -> f.getIdade() >30)
						.collect(Collectors.toSet())
						.forEach(System.out::println);
		
		System.out.println("\nObtendo uma implementação de Collection");
		funcionarios.stream()
						.filter(f ->f.getIdade() >30)
						.collect(Collectors.toCollection(HashSet::new))
						.forEach(System.out::println);
		
		System.out.println("\nCollection personalizado");
		Funcionario[] array = funcionarios.stream()	
						.filter(f -> f.getIdade() >30)
						.toArray(Funcionario[]::new);
		
		for(Funcionario f : array)
			System.out.println(f);
		
	}
}
