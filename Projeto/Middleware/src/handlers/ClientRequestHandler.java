/**
 * 
 */
package handlers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;

import crypt.EncriptaDecriptaAES;

/**
 * @author fabio
 * @author diogo
 * @author marina
 *
 */
public class ClientRequestHandler {
	private String host;
	private Integer port;

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
	 */
	Socket receiveSocket;
	private ObjectOutputStream operationRequested;
	private ObjectInputStream infos;
	Long ini, fim, acc = 0l;

	public byte[] receive() throws IOException, InterruptedException{
		byte[] msg = null, bytes = null;
		BufferedWriter writer = new BufferedWriter(new FileWriter("tempos.txt", true));
		infos = new ObjectInputStream(receiveSocket.getInputStream());
		try {
			bytes = (byte[]) infos.readObject();
			acc = 0l;
			ini = System.nanoTime();
			msg = EncriptaDecriptaAES.decrypt(bytes);
			fim = System.nanoTime();
			acc += fim - ini;
			writer.write(acc.toString());
			writer.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		writer.close();
		infos.close();
		receiveSocket.close();
		return msg;
	}

	public void send(byte[] serialMessage) throws UnknownHostException, IOException, NotBoundException {
		receiveSocket = new Socket(host, port);
		operationRequested = new ObjectOutputStream(receiveSocket.getOutputStream());
		byte[] encryptMessage = null;
		try {
			ini = System.nanoTime();
			encryptMessage = EncriptaDecriptaAES.encrypt( serialMessage );
			fim = System.nanoTime();
			acc += fim - ini;
		} catch (Exception e) {
			e.printStackTrace();
		}
		operationRequested.writeObject( encryptMessage );
	}

}