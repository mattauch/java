package lambda_method;

public class ExemploLambda2 {

	public static void main(String[] args) {
		// criando um objeto Runnable com classe an�nima
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("An�nima: " + i);
				}
			}
		};

		new Thread(r).start();

		// reescrever o c�digo acima usando o lambda
		System.out.println("\n\n\n");
		new Thread(() -> { //sempre coloca a vari�vel, mas quando n tem pode por () vazio
			for (int i = 0; i < 10; i++) {
				System.out.println("An�nima: " + i);
			}
		}).start();

	}

}