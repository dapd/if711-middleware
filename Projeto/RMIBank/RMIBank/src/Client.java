import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
	private static final int offset = 1000;
	private static final int it = offset + 10000;

	/**
	 * 
	 */
	public Client() {
		super();
	}

	public static void main(String[] args) {
		Long ini, fim, acc = 0l, total = 0l; //long integer
		byte[] response;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("tempos.txt"));
			Registry registry = LocateRegistry.getRegistry(6969);
			IMidBank midBank = (IMidBank) registry.lookup("MidBank");
			UUID uniqueId = UUID.randomUUID();

			for (int i = 0; i < it; i++) {
				acc = 0l;
				System.out.println("CRIAÇÃO DE CONTA");
				ini = System.nanoTime();   // <------- inicio contagem tempo
				response = midBank.createAccout(uniqueId, "senha123", 1, 1);
				fim = System.nanoTime();
				acc = registerTime(ini, fim, acc, i);
				printResponse(response);
				System.out.println("BALANCE");
				ini = System.nanoTime();
				response = midBank.accountBalance(uniqueId, 1);
				fim = System.nanoTime();
				acc = registerTime(ini, fim, acc, i);
				printResponse(response);
				System.out.println("PAGAMENTO DE FATURA");
				ini = System.nanoTime();
				response = midBank.creditCardBill(uniqueId, 1, 50.0);
				fim = System.nanoTime();
				acc = registerTime(ini, fim, acc, i);
				printResponse(response);
				System.out.println("PAGAMENTO DE CONTA");
				ini = System.nanoTime();
				response = midBank.payment(uniqueId, 1, "20181100003000", 30.0);
				fim = System.nanoTime();
				acc = registerTime(ini, fim, acc, i);
				printResponse(response);
				System.out.println("BALANCE");
				ini = System.nanoTime();
				response = midBank.accountBalance(uniqueId, 1);
				fim = System.nanoTime();
				acc = registerTime(ini, fim, acc, i);
				printResponse(response);
				System.out.println("ENCERRAMENTO DA CONTA");
				ini = System.nanoTime();
				response = midBank.deleteAccount(uniqueId, 1);
				fim = System.nanoTime();
				acc = registerTime(ini, fim, acc, i);
				printResponse(response);
				writer.write(acc.toString());
				writer.newLine();
				response = null;
				total += acc;
			}
			System.out.println("Tempo medio de comunicacao: " + ((double) total / (double) (it - offset)));
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
	
	private static Long registerTime(Long ini, Long fim, Long acc, int i) {
		acc += i >= offset ? fim - ini : 0;
		return acc;
	}

	private static void printResponse(byte[] response) throws IOException, InterruptedException {
		System.out.println(new String(response));
		Thread.sleep(5);
	}

}
