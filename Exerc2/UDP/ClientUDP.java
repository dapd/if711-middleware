/**
 * 
 */
package client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/**
 * @author faabi
 *
 */
public class Client {

	private static final String END = String.valueOf('\0');
	private static final String CLOSE = "close";
	private static final int BUF_SIZE = 1024;
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Writer tempos = new FileWriter("temposUDP", true);
		BufferedWriter writerTempos = new BufferedWriter(tempos);
		long ini, fim, acc = 0, i;
		Random random = new Random(System.currentTimeMillis());
		DatagramSocket dataSckt = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		int it = 5000;
		for (i = 0; i < it; i++) {
			int numFile = random.nextInt(100);
			String msg = "file" + numFile + ".txt";
			ini = System.currentTimeMillis();
			envia(dataSckt, address, msg);
			trataResposta(dataSckt, msg);
			fim = System.currentTimeMillis();
			acc += fim - ini;
		}
		double med = acc/(double)it;
//		writerTempos.append("Tempo para "+i+" arquivos: "+String.valueOf(med)+"ms");
//		writerTempos.newLine();
		envia(dataSckt, address, CLOSE);
		dataSckt.close();
//		writerTempos.close();
		System.out.println("Tempo para "+i+" arquivos: "+String.valueOf(med)+"ms");
	}

	private static void trataResposta(DatagramSocket dataSckt, String nomeArquivo) throws IOException {
		String rsp;
		byte[] data = new byte[BUF_SIZE];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		Writer out = new FileWriter("C:\\Middleware\\exe2\\RepositorioUDP\\download\\"+nomeArquivo);
		BufferedWriter writer = new BufferedWriter(out);
		boolean ended = false;
		do {
			dataSckt.receive(packet);
			rsp = new String(packet.getData(), 0, packet.getLength());			
			if (ended = !rsp.equals(END)) {
				writer.write(rsp);
				writer.newLine();
//				System.out.println(rsp);
			}
		} while (ended);
		writer.close();
	}

	private static byte[] envia(DatagramSocket dataSckt, InetAddress address, String msg) throws IOException {
		byte[] data;
		data = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, address, 1234);
		dataSckt.send(packet);
		return data;
	}
}
