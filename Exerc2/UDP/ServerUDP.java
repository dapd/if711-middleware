/**
 * 
 */
package server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author faabi
 *
 */
public class Server {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		byte b[] = null;
		DatagramSocket dsoc = new DatagramSocket(1234);
		boolean connected = true;
		while (connected) {
			DatagramPacket dp = trataConexao(b, dsoc);
			String in = convertePedido(dp);
			connected = trataDesconexao(connected, in);
			if (connected) {
				Scanner scanner = carregaPedido(in);
				b = trataEnvio(b, dsoc, scanner, dp);
				scanner.close();
			} else {
				dsoc.close();
			}

		}
	}

	private static boolean trataDesconexao(boolean connected, String in) {
		if (in.equals("close")) {
			connected = false;
		}
		return connected;
	}

	private static Scanner carregaPedido(String in) throws FileNotFoundException {
		File f = new File("C:\\Middleware\\exe2\\RepositorioUDP\\acervo\\" + in);
		Scanner scanner = new Scanner(f);
		return scanner;
	}

	private static String convertePedido(DatagramPacket dp) {
		String in = new String(dp.getData(), 0, dp.getLength());
		return in;
	}

	private static DatagramPacket trataConexao(byte[] b, DatagramSocket dsoc) throws IOException {
		b = new byte[1024];
		DatagramPacket dp = new DatagramPacket(b, b.length);
		dsoc.receive(dp);
		return dp;
	}

	private static byte[] trataEnvio(byte[] b, DatagramSocket dsoc, Scanner scanner, DatagramPacket dp)
			throws IOException {
		InetAddress address = dp.getAddress();
		int port = dp.getPort();
		while (scanner.hasNextLine()) {
			b = scanner.nextLine().getBytes();
			dp = new DatagramPacket(b, b.length, address, port);
//			System.out.println(new String(dp.getData(), 0, dp.getLength()));
			dsoc.send(dp);
		}
		String end = String.valueOf('\0');
		b = end.getBytes();
		dsoc.send(new DatagramPacket(b, b.length, address, port));
		return b;
	}
}
