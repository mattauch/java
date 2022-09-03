package predicado;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import dominio.Funcionario;

public class ExemploPredicado {

	public static void main(String[] args) {

		Predicate<Integer> menorQue18 = i -> i < 18; // new Predicate<Integer>() {public boolean test()...}
		System.out.println(menorQue18.test(10));
		System.out.println(menorQue18.test(18));

		Predicate<Integer> maiorQue10 = i -> i > 10; // new Predicate<Integer>() {public boolean test()...}
		// System.out.println(maiorQue10.test(9));
		// System.out.println(maiorQue10.test(11));

		Predicate<Integer> menorQue20 = i -> i < 20; // new Predicate<Integer>() {public boolean test()...}
		// System.out.println(menorQue20.test(15));
		// System.out.println(menorQue20.test(22));

		// retorna true se está entre 10 e 20
		boolean resultado = maiorQue10.and(menorQue20).test(12);
		System.out.println(resultado);

		// retorna true se NÃO está entre 10 e 20
		boolean resultado2 = maiorQue10.and(menorQue20).negate().test(30);
		System.out.println(resultado2);

		Funcionario f1 = new Funcionario(1, "Alberto Roberto", 70);
		Predicate<Funcionario> funcMaior18 = f -> f.getIdade() >=18;
		Predicate<Funcionario> funcMenor60 = f -> f.getIdade() <=60;
		boolean trabalha = funcMaior18.and(funcMenor60).test(f1);
		System.out.println(trabalha ? "é um trabalhador" : "é menor ou aposentado");
		
		//Predicado com 2 argumentos
		BiPredicate<String, Integer> seTamanhoValido = (palavra, tamanho) -> palavra.length() >= tamanho;
		
		boolean palavra1 = seTamanhoValido.test("Lucas", 4);
		System.out.println(palavra1);
		
		boolean palavra2 = seTamanhoValido.test("Antonela", 7);
		System.out.println(palavra2);
		

	}

}
