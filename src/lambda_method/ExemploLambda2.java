package lambda_method;

public class ExemploLambda2 {

	public static void main(String[] args) {
		// criando um objeto Runnable com classe anônima
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Anônima: " + i);
				}
			}
		};

		new Thread(r).start();

		// reescrever o código acima usando o lambda
		System.out.println("\n\n\n");
		new Thread(() -> { //sempre coloca a variável, mas quando n tem pode por () vazio
			for (int i = 0; i < 10; i++) {
				System.out.println("Anônima: " + i);
			}
		}).start();

	}

}