/**
 * 
 */
package handlers;

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

	public byte[] receive() throws IOException, InterruptedException{
		byte[] msg = null, bytes = null;
		infos = new ObjectInputStream(receiveSocket.getInputStream());
		try {
			bytes = (byte[]) infos.readObject();
			msg = EncriptaDecriptaAES.decrypt(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infos.close();
		receiveSocket.close();
		return msg;
	}

	public void send(byte[] serialMessage) throws UnknownHostException, IOException, NotBoundException {
		byte[] encryptMessage = null;
		receiveSocket = new Socket(host, port);
		operationRequested = new ObjectOutputStream(receiveSocket.getOutputStream());
		try {
			encryptMessage = EncriptaDecriptaAES.encrypt( serialMessage );
		} catch (Exception e) {
			e.printStackTrace();
		}
		operationRequested.writeObject( encryptMessage );
	}

}