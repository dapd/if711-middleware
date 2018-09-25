package client;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.net.Socket;
import java.util.Random;

public class Client {

	public static void main(String[] args) throws IOException {
		Random rand = new Random(System.currentTimeMillis());
		int i = 0;
		long ini = 0, fim = 0, acc = 0;
		int it = 5000;
		while (i < it) {
			try {
				// Conexão com servidor
				// System.out.println("Conectando ao servidor");
				Socket receiveSocket = new Socket("localhost", 1234);
				// System.out.println("Conexao estabelecida");

				// Cliente escolhe arquivo para baixar
				// System.out.println("Cliente escolhe arquivo dentre 100 disponiveis...");

				String fileName = "file" + rand.nextInt(100) + ".txt";
				ObjectOutputStream chosenFile = new ObjectOutputStream(receiveSocket.getOutputStream());
				byte data[] = new byte[1024];

				// System.out.println("Recebendo arquivo " + fileName);

				// Armazenando nome e tamanho do arquivo
				// System.out.println("Nome do arquivo: " + fileName);
				int count = 0;
				int sum = 0;
				ini = System.currentTimeMillis();
				Writer out = new FileWriter("C:\\Middleware\\exe2\\RepositorioTCP\\download\\"+fileName);
				BufferedWriter writer = new BufferedWriter(out);
				chosenFile.writeObject(fileName);
				InputStream fileIn = receiveSocket.getInputStream();
				while ((count = fileIn.read(data)) > 0) {
					sum += count;
					writer.append(new String(data, 0, data.length));
				}
				writer.close();
				chosenFile.flush();
				// System.out.println("Tamanho do arquivo recebido: " + sum);

				// System.out.println("Download concluido...");
				fileIn.close();
				receiveSocket.close();
				fim = System.currentTimeMillis();
				acc += fim - ini;
			} catch (Exception e) {
				// System.out.println("Erro cliente : " + e.toString());
			}

			// System.out.println("\n##################### " + i + "
			// ############################\n");
			
			i++;
		}
		System.out.println("tempo: "+(acc/(double)it));
	}
}
