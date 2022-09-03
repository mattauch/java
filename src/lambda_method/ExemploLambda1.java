package lambda_method;

import java.util.List;
import java.util.function.Consumer;

import dominio.Funcionario;

public class ExemploLambda1 {

	public static void main(String[] args) {
		Funcionario p1 = new Funcionario(1, "Jo�o da Silva", 22);
		Funcionario p2 = new Funcionario(2, "Alberto Roberto", 33);
		Funcionario p3 = new Funcionario(3, "Marina Maria", 44);
		
		/*List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3); */

		//List<Pessoa> pessoas = Arrays.asList(p1, p2, p3); //cole��o mut�vel
		
		List<Funcionario> pessoas = List.of(p1, p2, p3); //cole��o imut�vel
		
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
		
		//4 forma -- n�o precisa criar a classe consumidor
		System.out.println("\nCom foreach funcional e classe an�nima");
		pessoas.forEach(new Consumer<Funcionario>() {

			@Override
			public void accept(Funcionario p) {
				System.out.println(p);
				
			}
		});
		
		//5 forma
		/*� um m�todo an�nimo
		 * 
		 * O que � lambda no Java?
		 * � uma forma de representar uma classe ou interface an�nima que possua um �nico m�todo (interface funcional)
		 * 
		 * -------Significa algo an�nimo e serve para chamar o m�todo numa interface funcional
		 * 
		 * N�o existe no Java, � um pr� compilador
		 */
		//Reescrevendo o c�digo acima com lambda ->
		Consumer<Funcionario> consumidor2 = (Funcionario p) -> { //arrowFunction public void accept(Pessoa p) {
			System.out.println(p);
		};
		
		System.out.println("\nCom foreach funcional e lambda");
		pessoas.forEach(consumidor2);
		
		//6 forma
		//simplificando o c�digo acima
		System.out.println("\nCom foreach funcional e lambda simplificado");
		pessoas.forEach(p -> System.out.println(p));
		
		
		
	}

}
