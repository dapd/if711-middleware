package proxy;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.Objects;

public class ClientProxy implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String host;
	protected int port;
	protected int objectId;
	
	public ClientProxy() {}
	public ClientProxy(final int p) throws UnknownHostException {}
	
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
	/*
	@Override
	public byte[] request(String filename) throws Throwable{
		Invocation inv = new Invocation();
		Termination ter = new Termination();
		
		ArrayList<Objects> parameters = new ArrayList<Object>();
		
		class Local{};
		
		String methodName = null;
		Requestor requestor = new Requestor();
		
		//information received from Client
		methodName = Local.class.getEnclosingMethod().getName();
		paramaters.add(x);
		parameters.add(y);
		
		//information sent to Requestor
		inv.setObjectId(this.getObjectId());
		inv.setIpAddress(this.getHost());
		inv.setPortNumber(this.getPort());
		inv.setOperationName(methodName);
		inv.setParameters(parameters);
		
		//invoke Requestor
		ter = requestor.invoke(inv);
		
		// @ Result sent back to Client
		return (Float) ter.getResult()
		
		
	}*/
}
