
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITxtRepo extends Remote {
	byte[] request(String filename) throws RemoteException, IOException;
}