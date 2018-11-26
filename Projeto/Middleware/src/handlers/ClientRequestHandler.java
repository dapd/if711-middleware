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
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tempos.txt", true));
			infos = new ObjectInputStream(receiveSocket.getInputStream());
			bytes = (byte[]) infos.readObject();
			acc = 0l;
			ini = System.nanoTime();
			msg = EncriptaDecriptaAES.decrypt(bytes);
			fim = System.nanoTime();
			acc += fim - ini;
			writer.write(acc.toString());
			writer.newLine();
			writer.close();
			infos.close();
			receiveSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public void send(byte[] serialMessage) throws UnknownHostException, IOException, NotBoundException {
		byte[] encryptMessage = null;
		try {
			receiveSocket = new Socket(host, port);
			operationRequested = new ObjectOutputStream(receiveSocket.getOutputStream());
			ini = System.nanoTime();
			encryptMessage = EncriptaDecriptaAES.encrypt( serialMessage );
			fim = System.nanoTime();
			acc += fim - ini;
			operationRequested.writeObject( encryptMessage );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}