/**
 * 
 */
package naming;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import proxy.Marshaller;

/**
 * @author fabio
 *
 */
public class NamingServer implements Runnable {

	private String host;
	private Integer port;

	private ServerSocket serverSocketTcp;
	private Socket sendSocket;

	private NamingRepository namingRepository = new NamingRepository();

	Marshaller marshaller = new Marshaller();

	/**
	 * @param host
	 * @param port
	 */
	public NamingServer(String host, Integer port) {
		super();
		this.host = host;
		this.port = port;
	}

	@Override
	public void run() {
		while (Boolean.TRUE) {
			try {
				serverSocketTcp = new ServerSocket(port);
				sendSocket = serverSocketTcp.accept();
				ObjectInputStream chosenFile = new ObjectInputStream(sendSocket.getInputStream());
				NamingRecord entry = (NamingRecord) chosenFile.readObject();
				switch (entry.getOperation()) {
				case "bind":
					namingRepository.addService(entry.getServiceName(), entry.getClientProxy());
					break;
				case "unbind":
					namingRepository.removeService(entry.getServiceName());
					break;
				case "lookup":
					send(namingRepository.getService(entry.getServiceName()));
					break;
				case "list":
					send(namingRepository.list());
					break;
				default:
					break;
				}
				serverSocketTcp.close();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void send(Object clientProxy) throws IOException, InterruptedException {
		ObjectOutputStream out = (ObjectOutputStream) sendSocket.getOutputStream();
		out.writeObject(clientProxy);
	}

}
