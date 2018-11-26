/**
 * 
 */
package handlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import crypt.EncriptaDecriptaAES;

/**
 * @author fabio
 *
 */
public class ServerRequestHandler {
	private Integer port;

	/**
	 * @param host
	 * @param port
	 */
	public ServerRequestHandler(Integer port) {
		super();
		this.port = port;
	}

	private ServerSocket serverSocketTcp;
	private Socket sendSocket;

	public byte[] receive() throws IOException, ClassNotFoundException {
		byte[] request = null;
		byte[] msg = null;
		try {
			// Inicializando servidor
			serverSocketTcp = new ServerSocket(port);
			sendSocket = serverSocketTcp.accept();
			// Recebendo informacoes do arquivo solicitado
			ObjectInputStream chosenFile = new ObjectInputStream(sendSocket.getInputStream());
			request = (byte[]) chosenFile.readObject();
			msg = EncriptaDecriptaAES.decrypt(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public void send(byte[] msg) throws IOException {
		byte[] encryptMsg = null;
		try {
			ObjectOutputStream out = new ObjectOutputStream(sendSocket.getOutputStream());
			encryptMsg = EncriptaDecriptaAES.encrypt(msg);
			out.writeObject(encryptMsg);
			out.close();
			sendSocket.close();
			serverSocketTcp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}