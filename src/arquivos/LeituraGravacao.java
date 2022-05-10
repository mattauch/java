package arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraGravacao {

	public static void gravar(String arquivo) {

		try {
			FileWriter gravador = new FileWriter(arquivo);
			gravador.write("Primeira linha");
			gravador.write("\n Segunda linha");
			gravador.write("\n Terceira linha");
			gravador.write("\n Quarta linha");

			gravador.close();
			System.out.println("Arquivo gravado com sucesso!");

		} catch (IOException e) {
			System.out.println("Erro durante a gravação do arquivo:\n" + arquivo);
			e.printStackTrace();
		}

	}

	public static void ler(String arquivo) {

		try {
			FileReader leitor = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha;
			while ((linha = buffer.readLine()) != null) {
				System.out.println(linha);
			}
			buffer.close();
			leitor.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado pela leitura: \n" + arquivo);
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Erro durante a leitura do arquivo:\n" + arquivo);
			e.printStackTrace();
		}

	}

	public static List<Operacao> lerExtrato(String arquivo) {
		try {
			FileReader leitor = new FileReader(arquivo);
			BufferedReader buffer = new BufferedReader(leitor);
			String colunas = buffer.readLine();
			String linha;
			List<Operacao> lista = new ArrayList<>();

			while ((linha = buffer.readLine()) != null) {
				Operacao operacao = processaLinha(linha);
				lista.add(operacao);

			}

			buffer.close();
			leitor.close();
			return lista;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo do extrato não encontrado");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Erro ao ler arquivo de extrato");
			e.printStackTrace();
		}
		return null;
	}

//	converte uma linha em um objeto Operacao
	public static Operacao processaLinha(String linha) {
//	0 = data
//	1 = valor
//	2 = identificador
//	3 = descrição
		String vetor[] = linha.split(",");
		String strData = vetor[0];
		String strValor = vetor[1];
		String id = vetor[2];
		String descricao = vetor[3];

//		converte tipo de dados
		double valor = Math.abs(Double.parseDouble(strValor)); // "14.00" -> 14.00

		Operacao operacao = new Operacao();
		operacao.setData(strData);
		operacao.setIdentificador(id);
		operacao.setDescricao(descricao);
		operacao.setValor(valor);

		String nomeTipo;
		if (descricao.toUpperCase().contains("TRANSF") && descricao.toUpperCase().contains("PIX")) {
			nomeTipo = "TRANSFERENCIA_PIX";

		} else {
			String tipo[] = descricao.split(" ");

//		"transferência", "compra", "pagamento"
			nomeTipo = tipo[0].toUpperCase();
			if (nomeTipo.contains("TRANSF")) {
				nomeTipo = "TRANSFERENCIA";
			}
		}
		switch (nomeTipo) {
		case "TRANSFERENCIA":
			operacao.setTipo(TipoOperacao.TRANSFERENCIA);

			break;
		case "TRANSFERENCIA_PIX":
			operacao.setTipo(TipoOperacao.TRANSFERENCIA_PIX);

			break;
		case "COMPRA":
			operacao.setTipo(TipoOperacao.COMPRA);

			break;
		case "PAGAMENTO":
			operacao.setTipo(TipoOperacao.PAGAMENTO);

			break;
		default:
			operacao.setTipo(TipoOperacao.DESCONHECIDA);

		}
		return operacao;

	}

}
