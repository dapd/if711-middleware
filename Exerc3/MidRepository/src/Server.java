import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 */

/**
 * @author fabio
 *
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
			Registry registry = LocateRegistry.createRegistry(1234);
			ITxtRepo repo = new TxtRepoImpl();
			registry.rebind("txtRepo", repo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
