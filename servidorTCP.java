package socket.TCP;

import java.io.*;
import java.net.*;

class servidorTCP {

	public static void main(String argv[]) throws Exception {
		String fraseCliente;
		String FraseMaiusculas;
		
		ServerSocket socketRecepcao = new ServerSocket(6789);

		while (true) {
			Socket socketConexao = socketRecepcao.accept();
			
			BufferedReader doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
			DataOutputStream paraCliente = new DataOutputStream(socketConexao.getOutputStream());
			fraseCliente = doCliente.readLine();
			FraseMaiusculas = fraseCliente.toUpperCase() + '\n';
			paraCliente.writeBytes(FraseMaiusculas);
		}
	}
}