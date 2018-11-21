package client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
import java.util.Random;
import java.util.UUID;

import middleware.MidBankProxy;
import naming.NamingProxy;

/**
 * 
 */

/**
 * @author fabio
 * @author diogo
 */
public class Client {

	private static final int it = 1000;
	private static final Random random = new Random();

	/**
	 * 
	 */
	public Client() {
		super();
	}

	public static void main(String[] args) throws NotBoundException, IOException, InterruptedException, UnknownHostException  {
		Long ini, fim, acc = 0l; //long integer
		byte[] response;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tempos.txt"));
			MidBankProxy midBank = (MidBankProxy) new NamingProxy("localhost", 6969).lookup("MidBank");
			UUID uniqueId = UUID.randomUUID();
			for (int i = 0; i < it; i++) {
				ini = System.nanoTime();   // <------- inicio contagem tempo
				response = midBank.createAccout(uniqueId, "senha123", 1, 1);
				response = midBank.accountBalance(uniqueId, 1);
				response = midBank.creditCardBill(uniqueId, 1, 50.0);
				response = midBank.payment(uniqueId, 1, "20181100003000", 30.0);
				response = midBank.deleteAccount(uniqueId, 1);
				fim = System.nanoTime();   // <------- fim contagem tempo
				Long elapsed = fim - ini;
				acc += elapsed;
				writer.write(elapsed.toString());
				writer.newLine();
				response = null;
				Thread.sleep(5);
			}
			System.out.println("Tempo medio de comunicacao: " + ((double) acc / (double) it));
			writer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
