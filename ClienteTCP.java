package socket.TCP;

import java.io.*;
import java.net.*;

class ClienteTCP {

	public static void main(String argv[]) throws Exception {
		String frase;
		String fraseModificada;

		System.out.println("escreva mensagem ");
		BufferedReader doUsuario = new BufferedReader(new InputStreamReader(System.in));
		Socket socketCliente = new Socket("127.0.0.1", 6789);

		DataOutputStream paraServidor = new DataOutputStream(socketCliente.getOutputStream());
		BufferedReader doServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
		frase = doUsuario.readLine();
		paraServidor.writeBytes(frase + '\n');
		fraseModificada = doServidor.readLine();
		System.out.println("Do Servidor: " + fraseModificada);
		socketCliente.close();
	}
}