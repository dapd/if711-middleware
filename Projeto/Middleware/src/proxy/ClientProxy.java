package proxy;

import java.io.Serializable;
//import java.rmi.UnknownHostException;

public class ClientProxy implements Serializable {
	private static final long serialVersionUID = 1L;
	private String host;
	private int port;
	private int objectId;

	public ClientProxy() {
	}

	/**
	 * @param host
	 * @param port
	 * @param objectId
	 */
	
	public ClientProxy(String host, int port, int objectId) {
		super();
		this.host = host;
		this.port = port;
		this.objectId = objectId;
	}
	
	public ClientProxy(final int p) {
		this.port = p;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
}
