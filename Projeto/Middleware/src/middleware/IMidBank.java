package middleware;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMidBank extends Remote {
	byte[] request(String bankMethod) throws RemoteException, IOException;
}
