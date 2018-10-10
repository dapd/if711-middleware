package middleware;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import proxy.ClientProxy;
import proxy.Invocation;
import proxy.Requestor;

public class TxtProxy extends ClientProxy implements ITxtRepo {

	/**
	 * @param host
	 * @param port
	 * @param objectId
	 */
	public TxtProxy(String host, int port, int objectId) {
		super(host, port, objectId);
	}

	public TxtProxy() {

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5963528753775146077L;

	public byte[] request(String filename) throws RemoteException, IOException {
		List<String> parameters = new ArrayList<>();
		parameters.add(filename);
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName("request");
		invok.setParameters(parameters);
		byte[] response = null;
		try {
			response = requestor.invoke(invok);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
