package lambda_method;

public class ExemploLambd3 {

	public static void main(String[] args) {

		// [] = lista, sequ�ncia que s� pode ter n�meros
		// {} = exatamente 5 carcteres
		// express�o regular

		// primeiramente vamos implementar a interface usando a classe an�nima
		Validador<String> validadorCep1 = new Validador<String>() {

			@Override
			public boolean validar(String cep) {
				// System.out.println("84051-290".matches("[0-9]{5}-[0-9]{3}"));
				return cep.matches("[0-9]{5}-[0-9]{3}");
			}
		};
		//agora com lambda
		Validador<String> validadorCep2 = cep -> cep.matches("[0-9]{5}-[0-9]{3}");
		
		//testando
		System.out.println(validadorCep2.validar("84051-290") ? "Cep v�lido" : "Cep inv�lido");

	}
}
