package middleware;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import proxy.ClientProxy;
import proxy.Invocation;
import proxy.Requestor;

public class MidBankProxy extends ClientProxy implements IMidBank{
	/**
	 * @param host
	 * @param port
	 * @param objectId
	 */
	
	public MidBankProxy (String host, int port, int objectId) {
		super(host,port,objectId);
	}
	
	public MidBankProxy() {
		
	}
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 5963528753775146077L;
	
	public byte[] request(String bankMethod) throws RemoteException, IOException {
		List<String> parameters = new ArrayList<>();
		parameters.add(bankMethod);
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName("request");
		invok.setParameters(parameters);
		byte[] response = null;
		try {
			response = requestor.invoke(invok);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	/*abertura de conta, login, transferencia, consulta de saldo, pagamento de boleto, ver fatura*/
	public String createAccout(String emailAddress, String pswd) throws Throwable{ //retorna mensagem de confirmação
		String msg = null;
		return msg;
	}
	
	public String login(String emailAddress, String pswd) throws Throwable{ //retorna mensagem de confirmação
		String msg = null;
		return msg;
	}
	
	public String moneyTransfer(int bankBranchNumber, int accountNumber, String bankName, float value, String emailAddress) throws Throwable{ //retorna mensagem de confirmação ou erro
		String msg = null;
		return msg;
	}
	
	public float accountBalance(String emailAddress) throws Throwable{ //retorna o valor
		float msg = 0;
		return msg;
	}
	
	public String payment (String emailAddress, String billNumber) throws Throwable{ //retorna mensagem de confirmação ou erro
		String msg = null;
		return msg;
	}
	
	public float creditCardBill(String emailAddress) throws Throwable{ //retorna total da fatura até a consulta
		float msg = 0;
		return msg;
	}
}
