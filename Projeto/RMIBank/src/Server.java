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
			Registry registry = LocateRegistry.createRegistry(6969);
			IMidBank midBank = new MidBankImpl();
			registry.rebind("MidBank", midBank);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
