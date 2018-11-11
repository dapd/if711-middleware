/**
 * 
 */
package middleware;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author fabio
 *
 */
public interface ITxtRepo extends Remote {
	byte[] request(String filename) throws RemoteException, IOException;
}
