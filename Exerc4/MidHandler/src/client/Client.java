package client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
import java.util.Random;

import handlers.ClientRequestHandler;

/**
 * 
 */

/**
 * @author fabio
 * @author diogo
 */
public class Client {

	private static final String PROTOCOL = "rmi";
	private static final int it = 1000;
	private static final String downloadPath = System.getProperty("user.dir") + File.separator + "download"
			+ File.separator;
	private static final Random random = new Random();

	/**
	 * 
	 */
	public Client() {
		super();
	}

	public static void main(String[] args) throws NotBoundException, IOException, InterruptedException {
		String filename = null;
		Long ini, fim, acc = 0l;
		byte[] response;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tempos.txt"));
			ClientRequestHandler handler = new ClientRequestHandler("localhost", 1234);
			for (int i = 0; i < it; i++) {
				filename = getFileName();
				System.out.println("File Requested: " + filename);
				ini = System.nanoTime();
				handler.send(filename.getBytes(), PROTOCOL);
				response = handler.receive(PROTOCOL);
				fim = System.nanoTime();
				saveDownloadedFile(filename, response);
				System.out.printf("File %s Received!\n", filename);
				Long elapsed = fim - ini;
				acc += elapsed;
				writer.write(elapsed.toString());
				writer.newLine();
				response = null;
				Thread.sleep(5);
			}
			System.out.println("Tempo medio de comunicacao: " + ((double) acc / (double) it));
			writer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void saveDownloadedFile(String filename, byte[] response) throws IOException {
		FileWriter fileWriter = new FileWriter(downloadPath + filename);
		fileWriter.write(new String(response));
		fileWriter.close();
	}

	private static String getFileName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("file");
		stringBuilder.append(random.nextInt(100));
		stringBuilder.append(".txt");
		return stringBuilder.toString();
	}

}
