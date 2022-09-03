package funcoes;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import dominio.Funcionario;

/*
 * Podemos implementar as interfaces Supplier, Function e BiFunction através do Method Reference,
 * simplesmente referenciando o método construtor = Funcionario::new
 */
public class ReferenciandoConstrutores {

	public static void main(String[] args) {
		
		//Construtor sem argumentos (Construtor padrão)= usando Supplier
		Supplier<Funcionario> supplier = Funcionario::new; //cria um objeto supllier -> método get, igual feito na classe Supplier
		Funcionario f1 = supplier.get();
		System.out.println(f1);
		//idem: Funcionario f1 = new Funcionario();
		
		//Construtor com 1 argumento = usando Function
		Function<String, Funcionario> function = Funcionario::new; //cria um objeto Function
		Funcionario f2 = function.apply("Lucas");
		System.out.println(f2);
		//idem: Funcionario f1 = new Funcionario("Lucas");
		
		//Construtor com 2 argumentos = usando BiFunction
		BiFunction<String, Integer, Funcionario> bifunction = Funcionario::new; //cria um objeto BiFunction
		Funcionario f3 = bifunction.apply("Amanda", 23);
		System.out.println(f3);
		//idem: Funcionario f1 = new Funcionario("Amanda", 23);
	}

}
