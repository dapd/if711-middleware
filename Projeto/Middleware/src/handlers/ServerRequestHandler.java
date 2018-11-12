/**
 * 
 */
package handlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import middleware.IMidBank;
import middleware.MidBankImpl;

/**
 * @author fabio
 *
 */
public class ServerRequestHandler {
	private static final int BUF_SIZE = 1024;
	private static final String END = String.valueOf('\0');
	private Integer port;

	/**
	 * @param host
	 * @param port
	 */
	public ServerRequestHandler(Integer port) {
		super();
		this.port = port;
	}

	private Registry registry;
	private IMidBank repo;

	public byte[] receive() throws IOException, ClassNotFoundException {
		byte[] nomeArquivo = null;
		registry = LocateRegistry.getRegistry(6969);
		repo = new MidBankImpl();
		registry.rebind("txtRepo", repo);
		nomeArquivo = "rmi".getBytes();
		return nomeArquivo;
	}
	
	public void send(byte[] msg) throws IOException, NotBoundException {
		//metodo request do TxtRepoImpl ja trata o envio
		
	}
}
