package aula_servidor_multiusuario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//cliente usa a classe socket para conversar com o ServerSocket
public class ClienteRede {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// conexão do cliemte com o servidor na porta 1234
		System.out.println("Cliente tentando conexão com o servidor");
		Socket cliente = new Socket("192.168.1.128", 1234);

		// Fluxo de envio de dados (saída)
		DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());

		// Fluxo de recebimento de dados (entradas)
		DataInputStream entrada = new DataInputStream(cliente.getInputStream());

		// Envia dados para o servidor
		System.out.println("\n\n---------- CLIENTE ----------");
		System.out.println("\nEnviando dados para o servidor...");
		saida.writeUTF("Amanda: Como vai?");

		// Aguarda recebimento de dados do servidor
		System.out.println("Resposta do servidor: " + entrada.readUTF());

		// Fecha conexão
		cliente.close();
	}

}
