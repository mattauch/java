package lambda_method;

import java.util.List;
import java.util.function.Consumer;

import dominio.Funcionario;

public class ExemploLambda1 {

	public static void main(String[] args) {
		Funcionario p1 = new Funcionario(1, "João da Silva", 22);
		Funcionario p2 = new Funcionario(2, "Alberto Roberto", 33);
		Funcionario p3 = new Funcionario(3, "Marina Maria", 44);
		
		/*List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3); */

		//List<Pessoa> pessoas = Arrays.asList(p1, p2, p3); //coleção mutável
		
		List<Funcionario> pessoas = List.of(p1, p2, p3); //coleção imutável
		
		//1 forma -  com for
		for (int i=0; i< pessoas.size(); i++) {
			System.out.println(pessoas.get(i));
		}
		
		//2 forma - com foreach convencional
		System.out.println("\nCom foreach convencional");
		for (Funcionario p : pessoas) {
			System.out.println(p);
		}
		
		//3 forma - com foreach funcional -- precisa criar a classe consumidor
		System.out.println("\nCom foreach funcional e classe concreta");
		Consumer<Funcionario> consumidor = new Consumidor();
		pessoas.forEach(consumidor);
		
		//4 forma -- não precisa criar a classe consumidor
		System.out.println("\nCom foreach funcional e classe anônima");
		pessoas.forEach(new Consumer<Funcionario>() {

			@Override
			public void accept(Funcionario p) {
				System.out.println(p);
				
			}
		});
		
		//5 forma
		/*É um método anônimo
		 * 
		 * O que é lambda no Java?
		 * É uma forma de representar uma classe ou interface anônima que possua um único método (interface funcional)
		 * 
		 * -------Significa algo anônimo e serve para chamar o método numa interface funcional
		 * 
		 * Não existe no Java, é um pré compilador
		 */
		//Reescrevendo o código acima com lambda ->
		Consumer<Funcionario> consumidor2 = (Funcionario p) -> { //arrowFunction public void accept(Pessoa p) {
			System.out.println(p);
		};
		
		System.out.println("\nCom foreach funcional e lambda");
		pessoas.forEach(consumidor2);
		
		//6 forma
		//simplificando o código acima
		System.out.println("\nCom foreach funcional e lambda simplificado");
		pessoas.forEach(p -> System.out.println(p));
		
		
		
	}

}
