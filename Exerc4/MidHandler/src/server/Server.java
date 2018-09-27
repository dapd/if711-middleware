package server;

import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import handlers.ServerRequestHandler;

/**
 * 
 */

/**
 * @author fabio
 * @author diogo
 */
public class Server {

	private static final String PROTOCOL = "rmi";

	/**
	 * 
	 */
	public Server() {
		super();
	}

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		if ("rmi".equals(PROTOCOL)) {
			LocateRegistry.createRegistry(6969);
		}
		try {
			ServerRequestHandler handler = new ServerRequestHandler(1234);
			while (true) {
				byte[] fileNameSerialized = handler.receive(PROTOCOL);
				String fileName = (new String(fileNameSerialized)).trim();
				if (!"rmi".equals(fileName)) {
					FileInputStream fileStream = new FileInputStream(new File(getFilePath(fileName).toString()));
					handler.send(fileStream.readAllBytes(), PROTOCOL);
					fileStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static StringBuilder getFilePath(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(System.getProperty("user.dir"));
		stringBuilder.append(File.separator);
		stringBuilder.append("acervo");
		stringBuilder.append(File.separator);
		stringBuilder.append(fileName);
		return stringBuilder;
	}

}
