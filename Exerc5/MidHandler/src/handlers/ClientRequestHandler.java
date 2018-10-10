/**
 * 
 */
package handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import middleware.ITxtRepo;

/**
 * @author fabio
 *
 */
public class ClientRequestHandler {
	private static final int BUF_SIZE = 1024;
	private static final String END = String.valueOf('\0');
	private String host;
	private Integer port;
	private byte[] data;
	
	/**
	 * @param host
	 * @param port
	 */
	public ClientRequestHandler(String host, Integer port) {
		super();
		this.host = host;
		this.port = port;
	}
	
	/*
	 * TCP
	 * */
	Socket receiveSocket;
	private ObjectOutputStream chosenFile;
	private InputStream fileIn;
	
	/*
	 * UDP
	 * */
	private DatagramSocket dataSckt;
	private InetAddress address;
	
	/*
	 * Middleware
	 * */
	private Registry registry;
	private ITxtRepo repo;
	private StringBuilder stringBuilder;
	private byte[] response;
	
	public byte[] receive(String protocol) throws IOException, InterruptedException {
		byte[] msg = null;
		switch (protocol) {
		case "tcp":
			data = new byte[BUF_SIZE];
			stringBuilder = new StringBuilder();
			fileIn = receiveSocket.getInputStream();
			while ((fileIn.read(data)) > 0) {
				stringBuilder.append(new String(data, 0, data.length));
			}
			msg = stringBuilder.toString().getBytes();
			fileIn.close();
			chosenFile.close();
			receiveSocket.close();
			break;
		case "udp":
			String str;
			stringBuilder = new StringBuilder();
			do {
				DatagramPacket packet = new DatagramPacket(new byte[BUF_SIZE], BUF_SIZE);
				dataSckt.receive(packet);
				str = new String(packet.getData(), 0, packet.getLength());
				stringBuilder.append(str);
			} while (!END.equals(str));
			msg = stringBuilder.toString().getBytes();
			dataSckt.close();
			break;
		case "rmi":
			msg = response;
			break;
		default:
			break;
		}
		return msg;
	}
	
	public void send(byte[] nomeArquivo, String protocol) throws UnknownHostException, IOException, NotBoundException {
		switch (protocol) {
		case "tcp":
			receiveSocket = new Socket(host, port);
			chosenFile = new ObjectOutputStream(receiveSocket.getOutputStream());
			chosenFile.writeObject(nomeArquivo);
			break;
		case "udp":
			dataSckt = new DatagramSocket();
			address = InetAddress.getByName(host);
			dataSckt.send(new DatagramPacket(nomeArquivo, nomeArquivo.length, address, port));
			break;
		case "rmi":
			registry = LocateRegistry.getRegistry(6969);
			repo = (ITxtRepo) registry.lookup("txtRepo");
			response = repo.request(new String(nomeArquivo));
			break;
		default:
			break;
		}
	}
	
}
