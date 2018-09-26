/**
 * 
 */
package requestHandler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import java.util.Scanner;

import middleware.ITxtRepo;
import middleware.TxtRepoImpl;

/**
 * @author fabio
 *
 */
public class ServerRequestHandler {
	private static final int BUF_SIZE = 1024;
	private String host;
	private Integer port;

	/**
	 * @param host
	 * @param port
	 */
	public ServerRequestHandler(Integer port) {
		super();
		this.port = port;
	}

	/**
	 * TCP
	 */
	private ServerSocket serverSocketTcp;
	private Socket sendSocket;

	/*
	 * UDP
	 */
	private DatagramSocket serverSocketUdp;
	private InetAddress address;

	/*
	 * Middleware
	 */
	private Registry registry;
	private ITxtRepo repo;
	private byte[] response;

	public byte[] receive(String protocol) throws IOException, ClassNotFoundException {
		byte[] nomeArquivo = null;
		switch (protocol) {
		case "tcp":
			// Inicializando servidor
			serverSocketTcp = new ServerSocket(port);
			sendSocket = serverSocketTcp.accept();
			// Recebendo informacoes do arquivo solicitado
			ObjectInputStream chosenFile = new ObjectInputStream(sendSocket.getInputStream());
			nomeArquivo = (byte[]) chosenFile.readObject();
			break;
		case "udp":
			serverSocketUdp = new DatagramSocket(port);
			DatagramPacket dp = new DatagramPacket(new byte[BUF_SIZE], BUF_SIZE);
			serverSocketUdp.receive(dp);
			nomeArquivo = dp.getData();
			this.port = dp.getPort();
			address = dp.getAddress();
			break;
		case "rmi":
			registry = LocateRegistry.createRegistry(port);
			ITxtRepo repo = new TxtRepoImpl();
			registry.rebind("txtRepo", repo);
			nomeArquivo = "rmi".getBytes();
			break;
		default:
			break;
		}
		return nomeArquivo;
	}

	public void send(byte[] msg, String protocol) throws IOException, NotBoundException {
		switch (protocol) {
		case "tcp":
			OutputStream out = sendSocket.getOutputStream();
			out.write(msg, 0, msg.length);
			out.close();
			sendSocket.close();
			serverSocketTcp.close();
			break;
		case "udp":
			serverSocketUdp.send(new DatagramPacket(msg, msg.length, address, port));
			serverSocketUdp.close();
			break;
		case "rmi":
			//metodo request do TxtRepoImpl ja trata o envio
			break;
		default:
			break;
		}
	}
}
