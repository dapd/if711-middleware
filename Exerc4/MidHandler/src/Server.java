import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import requestHandler.ServerRequestHandler;

/**
 * 
 */

/**
 * @author fabio
 * @author diogo
 */
public class Server {

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
			//Registry registry = LocateRegistry.createRegistry(1234);
			//ITxtRepo repo = new TxtRepoImpl();
			//registry.rebind("txtRepo", repo);
			ServerRequestHandler handler = new ServerRequestHandler(1234);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
