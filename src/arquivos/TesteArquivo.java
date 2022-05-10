package arquivos;

import java.util.List;

public class TesteArquivo {

	public static void main(String[] args) {
//		
//		String arquivo = "E:/CURSO JAVA AMANDA/aula07/src/arquivos.txt";
//		
////		LeituraGravacao.gravar(arquivo);
//		
//		LeituraGravacao.ler(arquivo);
//		

		String extrato = "E:/CURSO JAVA AMANDA/aula07/src/arquivos/extrato.csv";
		List<Operacao> lista = LeituraGravacao.lerExtrato(extrato);

		double soma = 0;
		for (Operacao operacao : lista) {
			if (operacao.getTipo() == TipoOperacao.COMPRA) {
				double valor = operacao.getValor();
				soma += valor;
				System.out.println(operacao);
			}
		}

		System.out.println(String.format("Total de compras R$ %.2f", soma));

		System.out.println("\n\nTodas as transferências:");
		for (Operacao operacao : lista) {
			if (operacao.getTipo() == TipoOperacao.TRANSFERENCIA) {
				System.out.println(operacao);
			}
		}
		System.out.println("\n\nTodas as transferências por PIX:");
		for (Operacao operacao : lista) {
			if (operacao.getTipo() == TipoOperacao.TRANSFERENCIA_PIX) {
				System.out.println(operacao);
			}
		}

		System.out.println("\n\nTodos os pagamentos:");
		for (Operacao operacao : lista) {
			if (operacao.getTipo() == TipoOperacao.PAGAMENTO) {
				System.out.println(operacao);
			}
		}

		/*
		 * // 012 String texto = "o rato roeu a roupa do rei de Roma";
		 * System.out.println(texto.length());
		 * System.out.println(texto.contains("gato"));
		 * System.out.println(texto.charAt(2)); System.out.println(texto.charAt(3));
		 * System.out.println(texto.charAt(4)); System.out.println(texto.charAt(5));
		 * 
		 * System.out.println(texto.startsWith("o rato"));
		 * System.out.println(texto.endsWith("Roma")); char vetor [] =
		 * texto.toCharArray(); for (char c : vetor) { System.out.print(c + " "); }
		 * System.out.println(); System.out.println(texto.toUpperCase()); String
		 * palavras [] = texto.split(" "); // quebra a frase em palavras for (String txt
		 * : palavras) { System.out.println(txt); }
		 */
	}

}
