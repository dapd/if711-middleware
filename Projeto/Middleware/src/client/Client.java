package client;

import java.io.BufferedWriter;
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

	private static final int it = 10000;
	private static final Random random = new Random();

	/**
	 * 
	 */
	public Client() {
		super();
	}

	public static void main(String[] args) throws NotBoundException, IOException, InterruptedException, UnknownHostException  {
		Long ini, fim, acc = 0l, total = 0l; //long integer
		byte[] response;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tempos.txt"));
			MidBankProxy midBank = (MidBankProxy) new NamingProxy("localhost", 6969).lookup("MidBank");
			UUID uniqueId = UUID.randomUUID();
			for (int i = 0; i < it; i++) {
				acc = 0l;
				ini = System.nanoTime();   // <------- inicio contagem tempo
				response = midBank.createAccout(uniqueId, "senha123", 1, 1);
				fim = System.nanoTime();
				acc += fim - ini;
				System.out.println("CONTA CRIADA");
				Thread.sleep(5);
				ini = System.nanoTime();
				response = midBank.accountBalance(uniqueId, 1);
				fim = System.nanoTime();
				acc += fim - ini;
				System.out.println("BALANCE");
				Thread.sleep(5);
				ini = System.nanoTime();
				response = midBank.creditCardBill(uniqueId, 1, 50.0);
				fim = System.nanoTime();
				acc += fim - ini;
				System.out.println("PAGAMENTO DE FATURA");
				Thread.sleep(5);
				ini = System.nanoTime();
				response = midBank.payment(uniqueId, 1, "20181100003000", 30.0);
				fim = System.nanoTime();
				acc += fim - ini;
				System.out.println("PAGAMENTO DE CONTA");
				Thread.sleep(5);
				ini = System.nanoTime();
				response = midBank.deleteAccount(uniqueId, 1);
				fim = System.nanoTime();
				acc += fim - ini;
				System.out.println("ENCERRAMENTO DA CONTA");
				writer.write(acc.toString());
				writer.newLine();
				response = null;
				Thread.sleep(5);
				total += acc;
			}
			System.out.println("Tempo medio de comunicacao: " + ((double) total / (double) it));
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
