package server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket sendServer = null;
		Socket sendSocket;
		String nomeArquivo;
		byte data[];
		int i = 0;

		try {
			// Inicializando servidor
			sendServer = new ServerSocket(1234);

			while (true) {
				// System.out.println("Aguardando conexao do cliente...");
				sendSocket = sendServer.accept();

				// System.out.println("Conexao estabelecida");
				data = new byte[1024];

				// Recebendo informacoes do arquivo solicitado
				ObjectInputStream chosenFile = new ObjectInputStream(sendSocket.getInputStream());
				nomeArquivo = (String) chosenFile.readObject();
				// System.out.println(nomeArquivo);

				// Criando classe do arquivo a ser enviado
				File file = new File("C:\\Middleware\\exe2\\RepositorioTCP\\acervo\\" + nomeArquivo);

				// Enviando arquivo
				// System.out.println("Enviando arquivo...");
				FileInputStream fileStream = new FileInputStream(file);
				BufferedInputStream fileBuffer = new BufferedInputStream(fileStream);
				OutputStream out = sendSocket.getOutputStream();

				int count = 0;
				int sum = 0;
				while ((count = fileBuffer.read(data)) > 0) {
					sum += count;
					out.write(data, 0, count);
					out.flush();
				}
				// System.out.println("Tamanho do arquivo enviado: " + sum);
				out.close();
				fileBuffer.close();
				fileStream.close();

				sendSocket.close();

				// System.out.println("Conexao encerrada");
				// System.out.println("\n##################### " + i + "
				// ############################\n");

				i++;
			}
		} catch (Exception e) {
			// System.out.println("Erro servidor : " + e.toString());
		}
	}
}
