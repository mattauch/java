package aula_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//cliente usa a classe socket para conversar com o ServerSocket
public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// conex�o do cliemte com o servidor na porta 1234
		System.out.println("Cliente tentando conex�o com o servidor");
		Socket cliente = new Socket("localhost", 1234);

		// Fluxo de envio de dados (sa�da)
		DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());

		// Fluxo de recebimento de dados (entradas)
		DataInputStream entrada = new DataInputStream(cliente.getInputStream());

		// Envia dados para o servidor
		System.out.println("\n\n---------- CLIENTE ----------");
		System.out.println("\nEnviando dados para o servidor...");
		saida.writeUTF("Ola, como vai?");

		// Aguarda recebimento de dados do servidor
		System.out.println("Resposta do servidor: " + entrada.readUTF());

		// Fecha conex�o
		cliente.close();
	}

}
