/**
 * 
 */
package handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;

import crypt.EncriptaDecriptaDES;

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
	 */
	Socket receiveSocket;
	private ObjectOutputStream operationRequested;
	private InputStream infos;
	private StringBuilder stringBuilder;

	public byte[] receive() throws IOException, InterruptedException {
		byte[] msg = null;
		data = new byte[BUF_SIZE];
		stringBuilder = new StringBuilder();
		infos = receiveSocket.getInputStream();
		while ((infos.read(data)) > 0) {
			stringBuilder.append(new String(data, 0, data.length));
		}
		msg = stringBuilder.toString().getBytes();
		infos.close();
		receiveSocket.close();
		return EncriptaDecriptaDES.decripta(msg);
	}

	public void send(byte[] serialMessage) throws UnknownHostException, IOException, NotBoundException {
		receiveSocket = new Socket(host, port);
		operationRequested = new ObjectOutputStream(receiveSocket.getOutputStream());
		operationRequested.writeObject(EncriptaDecriptaDES.encripta( serialMessage ) );
	}

}
