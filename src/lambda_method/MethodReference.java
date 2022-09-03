package lambda_method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import dominio.Funcionario;

/*
 * Usamos o method reference quando queremos executar o mesmo método para todos os elementos de uma lista de objetos
 */
public class MethodReference {

	public static void main(String[] args) {
		Funcionario p1 = new Funcionario(1, "João da Silva", 22);
		Funcionario p2 = new Funcionario(2, "Alberto Roberto", 33);
		Funcionario p3 = new Funcionario(3, "Marina Maria", 44);
		List<Funcionario> pessoas = Arrays.asList(p1, p2, p3);
		
		//List.of = lista IMUTÁVEL
		//Arrays.asList = lista MUTÁVEL
		
		//chama o método info() de classe Pessoa para todos os elementos da lista
		
		//1 usando o lambda
		System.out.println("Usando o lambda");
		pessoas.forEach(p -> p.info());
		
		//2 usando reference (Method Reference)
		System.out.println("\nUsando o Method Reference");
		pessoas.forEach(Funcionario :: info); //não pode ter parâmetro nenhum
		
		//3
		System.out.println("\nUsando :: (Reference)");
		Consumer<Funcionario> info = Funcionario :: info;
		pessoas.forEach(info);
		
		//Comparator - ordenação
		System.out.println("\nOrdenação pelo nome");
		pessoas.sort(Comparator.comparing(Funcionario :: getNome));
		pessoas.forEach(System.out::println);
		
		System.out.println("\nOrdenação pela idade");
		pessoas.sort(Comparator.comparing(Funcionario :: getIdade));
		pessoas.forEach(System.out::println);
		

	}

}
