package handlers;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import middleware.IMidBank;

public class ClientRequestHandler {
	private String host;
	private Integer port;
	private byte[] data;
	private int sentMessageSize;
	private int receiveMessageSize;
	
	/**
	 * @param host
	 * @param port
	 */
	public ClientRequestHandler(String host, Integer port) {
		super();
		this.host = host;
		this.port = port;
	}

	private Registry registry;
	private IMidBank repo;
	private byte[] response;
	
	public byte[] receive() throws IOException, InterruptedException {
		return response;
	}
	
	public void send(byte[] bankMethod) throws UnknownHostException, IOException, NotBoundException {
	registry = LocateRegistry.getRegistry(6969);
	repo = (IMidBank) registry.lookup("bankMethod");
	response = repo.request(new String());
	}
	
}
