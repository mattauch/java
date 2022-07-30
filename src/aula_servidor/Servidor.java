package aula_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Sockets ou soquetes
 * sockets se comunicam atrav�s do protocolo TCP/IP (StateFull) -> funciona como se fosse uma liga��o telefonica, enquanto um n�o desliga a comunica��o continua
 * TCP/IP � usada para comunica��o segura, logo � lenta (quest�o de segundos, por isso para jogos online n�o serve)
 * UDP (Datagramas) - usado para jogos online ou quando h� muitos usu�rios (lembrar de carta, pode ser enviada para v�rias pessoas ao mesmo tempo)
 * 
 * Temos 2 tipos de sockets:
 * - ServerSocket - cria um Socket servidor -> representa uma porta
 * Porta: � um n�mero de 0 a 65535
 * Evitar portas entre 0 e 1024 -> usadas pelo sistema operacional
 * - Socket - cria um socket cliente -> acessa aporta da socket servidor
 */

public class Servidor {

	public static void main(String[] args) throws IOException {

		// Cria a conex�o do servidor na porta 1234
		ServerSocket servidor = new ServerSocket(1234);

		// aguarda a conex�o com o cliente na porta 1234
		System.out.println("Servidor aguardando na porta 1234");
		Socket cliente = servidor.accept();
		System.out.println("Cliente conectado");

		// Fluxo de recebimento
		DataInputStream entrada = new DataInputStream(cliente.getInputStream());

		// Fluxo de envio
		DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());

		// le mensagem do cliente
		String mensagemRecebida = entrada.readUTF();

		System.out.println("\n\n---------- SERVIDOR ---------");
		System.out.println("\nMensagem recebida do cliente: " + mensagemRecebida);
		if (mensagemRecebida.equalsIgnoreCase("Ola, como vai?")) {
			saida.writeUTF("Tudo bem! E voc�?");
		} else {
			saida.writeUTF("OK");
		}

		cliente.close();
		servidor.close();

	}

}
