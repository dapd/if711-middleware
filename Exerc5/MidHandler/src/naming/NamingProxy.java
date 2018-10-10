/**
 * 
 */
package naming;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import proxy.ClientProxy;

/**
 * @author fabio
 *
 */
public class NamingProxy implements INaming {
	private String host;
	private Integer port;
	private NamingServer namingServer = null;
	private Socket receiveSocket;
	private ObjectOutputStream chosenFile;

	/**
	 * @param host
	 * @param port
	 */
	public NamingProxy(String host, Integer port) {
		super();
		this.host = host;
		this.port = port;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see naming.INaming#bind(java.lang.String, proxy.ClientProxy)
	 */
	@Override
	public void bind(String serviceName, ClientProxy clientProxy) {
		if (namingServer == null) {
			namingServer = new NamingServer(host, port);
			Thread namingService = new Thread(namingServer);
			namingService.start();
		}
		clientProxy.setHost(host);
		clientProxy.setPort(1234);
		clientProxy.setObjectId(new Random(System.currentTimeMillis()).nextInt());
		NamingRecord record = new NamingRecord("bind", serviceName, clientProxy);
		send(record);
	}

	private void send(NamingRecord record) {
		try {
			receiveSocket = new Socket(host, port);
			chosenFile = new ObjectOutputStream(receiveSocket.getOutputStream());
			chosenFile.writeObject(record);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see naming.INaming#lookup(java.lang.String)
	 */
	@Override
	public ClientProxy lookup(String serviceName) {
		ClientProxy clientProxy = null;
		NamingRecord record = new NamingRecord("lookup", serviceName, null);
		send(record);
		clientProxy = (ClientProxy) receive();
		return clientProxy;
	}

	private Object receive() {
		Object response = null;
		try {
			response = new ObjectInputStream(receiveSocket.getInputStream()).readObject();
//			response = marshaller.unmarshallGeneric(allBytes);
			receiveSocket.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see naming.INaming#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<String> list() {
		ArrayList<String> response = null;
		send(new NamingRecord("list", null, null));
		response = (ArrayList<String>) receive();
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see naming.INaming#unbind(java.lang.String)
	 */
	@Override
	public void unbind(String serviceName) {
		send(new NamingRecord("unbind", serviceName, null));
	}

}
