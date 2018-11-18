/**
 * 
 */
package handlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
		byte[] nomeArquivo = null;
		// Inicializando servidor
		serverSocketTcp = new ServerSocket(port);
		sendSocket = serverSocketTcp.accept();
		// Recebendo informacoes do arquivo solicitado
		ObjectInputStream chosenFile = new ObjectInputStream(sendSocket.getInputStream());
		nomeArquivo = (byte[]) chosenFile.readObject();
		return nomeArquivo;
	}

	public void send(byte[] msg) throws IOException {
		OutputStream out = sendSocket.getOutputStream();
		out.write(msg, 0, msg.length);
		out.close();
		sendSocket.close();
		serverSocketTcp.close();
	}
}
