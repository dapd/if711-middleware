package server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import requestHandler.ServerRequestHandler;

/**
 * 
 */

/**
 * @author fabio
 * @author diogo
 */
public class Server {

	private static final String PROTOCOL = "udp";

	/**
	 * 
	 */
	public Server() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerRequestHandler handler = new ServerRequestHandler(1234);
			while (true) {
				byte[] fileName = handler.receive(PROTOCOL);
				if (!"rmi".equals(fileName.toString())) {
					FileInputStream fileStream = new FileInputStream(new File(System.getProperty("user.dir")
							+ File.separator + "acervo" + File.separator + new String(fileName)));
					BufferedInputStream fileBuffer = new BufferedInputStream(fileStream);
					handler.send(fileBuffer.readAllBytes(), PROTOCOL);
					fileBuffer.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
