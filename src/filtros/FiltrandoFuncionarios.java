package filtros;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import dominio.Funcionario;

public class FiltrandoFuncionarios {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario(1, "Rafael", 16, 1200f);
		Funcionario f2 = new Funcionario(2, "Gabriel", 33, 4500f);
		Funcionario f3 = new Funcionario(3, "Josiel", 44, 7500f);
		Funcionario f4 = new Funcionario(4, "Miguel", 55, 9000f);
		Funcionario f5 = new Funcionario(5, "Angela", 22, 2500f);
		Funcionario f6 = new Funcionario(6, "Diana", 65, 15000f);
		Funcionario f7 = new Funcionario(7, "Sofia", 17, 1300f);
		
		//Cria lista imutável
		List<Funcionario> funcionarios = List.of(f1, f2, f3, f4, f5, f6, f7);
		
		System.out.println("\nLimitando quantidade");
		funcionarios.stream()  //Stream permite conectar métodos
						.limit(3)
						.forEach(System.out::println);  //consumer e method reference
		
		System.out.println("\nFiltrando por idade");
		funcionarios.stream() 
						.filter(new Predicate<Funcionario>() {
						
							@Override
							public boolean test(Funcionario f) {
								return f.getIdade() >=18;
							}
						})
						.forEach(System.out::println);
		//O próximo exemplo fará a mesma coisa q o anterior, porém com lambda
		
		System.out.println("\nFiltrando por salário: acima de R$3.000,00");
		funcionarios.parallelStream() //parallelStream = substitui a Thread
							.filter(f -> f.getSalario() >=3000)
							.forEach(System.out::println);
		
		System.out.println("\nRemovendo todos os maiores de idade");
		List<Funcionario> seMaiores = new ArrayList<>(funcionarios);
		seMaiores.removeIf(f -> f.getIdade() >=18);
		seMaiores.forEach(System.out::println);
		
		//map() executa uma função para cada elemento da lista
		//aumentando 50% o salário 
		System.out.println("\nExemplo map e function, dobrando os salários");
		funcionarios.stream()
						.map(new Function<Funcionario, Funcionario>() {

							@Override
							public Funcionario apply(Funcionario f) {
								f.setSalario(f.getSalario() * 1.5f);
								return f;
							}
						}).forEach(f -> System.out.println(f+"\tSalário:" + f.getSalario()));
			
		System.out.println("\nExemplo map e function com lambda, dobrando os salários");
		funcionarios.stream()
						.map(f -> f.getSalario() * 1.5f)
						.forEach(System.out::println);
		
		System.out.println("\nObtém somente as idades com map");
		funcionarios.stream()
						.map(Funcionario::getIdade) //método de referência = pega a idade de Funcionario
						.forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		funcionarios.stream()
						.map(new Function<Funcionario, Integer>() {

							@Override
							public Integer apply(Funcionario f) {
								return f.getIdade();
							}
						}).forEach(System.out::println);
		
		System.out.println("\nObtém somente as idades com mapToInt");
		funcionarios.stream()	
						.mapToInt(Funcionario::getIdade)
						.forEach(System.out::println);
		
		System.out.println("\nAcha a menor idade");
		int menorIdade = funcionarios.stream()
						.mapToInt(Funcionario::getIdade)
						.min().getAsInt();
						System.out.println("Menor idade: " + menorIdade);
						
		System.out.println("\nAcha a maior idade");
		int maiorIdade = funcionarios.stream()
						.mapToInt(Funcionario::getIdade)
						.max().getAsInt();
						System.out.println("Maior idade: " + maiorIdade);
						
						
		System.out.println("\nMédia das idades");
		double mediaIdade = funcionarios.stream()
						.mapToInt(Funcionario::getIdade)
						.average()
						//.orElse(30);se não conseguir fazer a média, devolva 30
						.getAsDouble();
						System.out.println(mediaIdade);
						
		System.out.println("\nMédia de salários");
		double mediaSalarios = funcionarios.stream()
						.mapToDouble(Funcionario::getSalario)
						.average()
						.getAsDouble();
						System.out.printf("R$ %.2f ", mediaSalarios);
						
		System.out.println("\nOrdenando por idade");
		funcionarios.stream()
					.sorted(Comparator.comparingInt(Funcionario::getIdade))
					.forEach(System.out::println);
		
		System.out.println("\nOrdenando por idade (reverso)");
		funcionarios.stream()
		.sorted(Comparator.comparingInt(Funcionario::getIdade).reversed())
		.forEach(System.out::println);
		
		System.out.println("\nMenor salário");
		double menorSalario = funcionarios.stream()
											.mapToDouble(Funcionario::getSalario)
											.min()
											.getAsDouble();
											System.out.printf("R$ %.2f", menorSalario);
											
		System.out.println("\n\nSoma dos salários");
		double somaSalarios = funcionarios.stream()
											.mapToDouble(Funcionario::getSalario)
											.sum();
											System.out.printf("R$ %.2f", somaSalarios);
											
		System.out.println("\n\nIdade entre 18 e 50 anos");
		funcionarios.stream()
						.filter(f -> f.getIdade() >=18 && f.getIdade() <=50)
						.forEach(System.out::println);
		
		System.out.println("\n\nSalarios entre 3000 e 9000 com idades entre 18 e 50 anos");
		funcionarios.stream()
		.filter(f -> f.getSalario()>=3000 && f.getSalario() <=9000)
		.filter(f -> f.getIdade() >=18 && f.getIdade() <=50)
		.forEach(System.out::println);
		
		System.out.println("\n\nFiltra os nomes que inicia com a letra A");
		funcionarios.stream()
						.filter(f -> f.getNome().toUpperCase().startsWith("A"))
						.forEach(System.out::println);
		
		System.out.println("\n\nFiltrando os nomes que terminam com el");
		funcionarios.stream()
						.filter(f -> f.getNome().toLowerCase().endsWith("el"))
						.forEach(System.out::println);
		
		System.out.println("\n\nFiltrando nomes com múltiplos predicados");
		Predicate<Funcionario> iniciaA = f->f.getNome().startsWith("A");
		Predicate<Funcionario> iniciaR = f->f.getNome().startsWith("R");
		Predicate<Funcionario> iniciaM = f->f.getNome().startsWith("M");
		Predicate<Funcionario> iniciaF = f->!f.getNome().contains("F");
		Predicate<Funcionario> predComplexo = iniciaA.or(iniciaR).or(iniciaM).and(iniciaF);
		
		funcionarios.stream()
						.filter(predComplexo)
						.forEach(System.out::println);
		
		System.out.println("\n\nFiltrando salários com mútiplos predicados");
		Predicate<Funcionario> salMenorQue = f->f.getSalario() <2000;
		Predicate<Funcionario> salMaiorQue = f->f.getSalario() >10000;
		
		funcionarios.stream()
						.filter(salMaiorQue.or(salMenorQue))
						.forEach(f-> System.out.println(f + "\tSalários: R$ " + f.getSalario()));
		
		System.out.println("\n\nFiltrando salários com mútiplos predicados (and)");
		Predicate<Funcionario> salEntre2000 = f->f.getSalario() >=2000;
		Predicate<Funcionario> salEntre10000 = f->f.getSalario() <=10000;
		
		funcionarios.stream()
		.filter(salEntre2000.and(salEntre10000))
		.forEach(f-> System.out.println(f + "\tSalários: R$ " + f.getSalario()));
		
 	}

}
