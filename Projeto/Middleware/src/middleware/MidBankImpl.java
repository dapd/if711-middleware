package middleware;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MidBankImpl extends UnicastRemoteObject implements IMidBank {

	private static final long serialVersionUID = 1L;

	public MidBankImpl() throws RemoteException {
		super();
	}

	@Override
	public byte[] request(String bankMethod) throws RemoteException, IOException {
		byte data[] = new byte[1024];
		// Bank methods
		
		return data;

	}

}
