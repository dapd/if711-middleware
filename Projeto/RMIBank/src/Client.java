import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.UUID;

/**
 * 
 */

/**
 * @author fabio
 * @author diogo
 * @author marina
 *
 */
public class Client {

	private static final int it = 1000;
	private static final Random random = new Random(System.currentTimeMillis());

	/**
	 * 
	 */
	public Client() {
		super();
	}

	public static void main(String[] args) {
		Long ini, fim, acc = 0l;
		byte[] response;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tempos.txt"));
			Registry registry = LocateRegistry.getRegistry(6969);
			IMidBank midBank = (IMidBank) registry.lookup("MidBank");
			UUID uniqueId = UUID.randomUUID();

			for (int i = 0; i < it; i++) {
				ini = System.nanoTime();
				response = midBank.createAccout(uniqueId, "senha123", 1, 1);
				Thread.sleep(5);
				response = midBank.accountBalance(uniqueId, 1);
				Thread.sleep(5);
				response = midBank.creditCardBill(uniqueId, 1, 50.0);
				Thread.sleep(5);
				response = midBank.payment(uniqueId, 1, "20181100003000", 30.0);
				Thread.sleep(5);
				response = midBank.deleteAccount(uniqueId, 1);
				fim = System.nanoTime();
				Long elapsed = fim - ini - 20000000;
				acc += elapsed;
				writer.write(elapsed.toString());
				writer.newLine();
			}
			System.out.println("Tempo medio de comunicacao: " + ((double) acc / (double) it));
			writer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
