package middleware;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

	/*abertura de conta, encerramento de conta, login, transferencia, consulta de saldo, pagamento de boleto, ver fatura*/
	public byte[] createAccout(UUID uniqueId, String pswd, int accountNumber, int bankBranchNumber) throws RemoteException, IOException{ //retorna mensagem de confirmação
		List<String> parameters = new ArrayList<>();
		parameters.add(uniqueId.toString());
		parameters.add(pswd);
		parameters.add(String.valueOf(accountNumber));
		parameters.add(String.valueOf(bankBranchNumber));
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName(Operation.ACCOUNT_CREATION.getValor());
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
	
	public byte[] deleteAccount(UUID uniqueId, int accountNumber) throws RemoteException, IOException{
		List<String> parameters = new ArrayList<>();
		parameters.add(uniqueId.toString());
		parameters.add(String.valueOf(accountNumber));
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName(Operation.DELETE_ACCOUNT.getValor());
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
	
	public byte[] login(UUID uniqueId, String pswd) throws RemoteException, IOException{ //retorna mensagem de confirmação
		List<String> parameters = new ArrayList<>();
		parameters.add(uniqueId.toString());
		parameters.add(pswd);
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName(Operation.LOGIN.getValor());
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
	
	public byte[] moneyTransfer(UUID uniqueId, Integer debitAccountNumber, Integer debitBankBranchNumber, Integer creditAccountNumber, Integer creditBankBranchNumber, String bankName, Double amountToTransfer) throws RemoteException, IOException{ //retorna mensagem de confirmação ou erro
		List<String> parameters = new ArrayList<>();
		parameters.add(uniqueId.toString());
		parameters.add(debitAccountNumber.toString());
		parameters.add(debitBankBranchNumber.toString());
		parameters.add(String.valueOf(creditAccountNumber));
		parameters.add(String.valueOf(creditBankBranchNumber));
		parameters.add(String.valueOf(bankName));
		parameters.add(String.valueOf(amountToTransfer));
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName(Operation.TRANSFER.getValor());
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
	
	public byte[] accountBalance(UUID uniqueId, Integer accountNumber) throws RemoteException, IOException{ 
		List<String> parameters = new ArrayList<>();
		parameters.add(uniqueId.toString());
		parameters.add(accountNumber.toString());
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName(Operation.BALANCE.getValor());
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
	
	public byte[] payment (UUID uniqueId, Integer accountNumber, String billNumber, Double value) throws RemoteException, IOException{ //retorna mensagem de confirmação ou erro
		List<String> parameters = new ArrayList<>();
		parameters.add(uniqueId.toString());
		parameters.add(accountNumber.toString());
		parameters.add(billNumber);
		parameters.add(value.toString());
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName(Operation.PAYMENT.getValor());
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
	
	public byte[] creditCardBill(UUID uniqueId, Integer accountNumber, Double value) throws RemoteException, IOException{ //retorna total da fatura até a consulta
		List<String> parameters = new ArrayList<>();
		parameters.add(uniqueId.toString());
		parameters.add(accountNumber.toString());
		parameters.add(value.toString());
		Requestor requestor = new Requestor();
		Invocation invok = new Invocation(this.getHost(), this.getPort(), this.getObjectId());
		invok.setOperationName(Operation.CARD_BILL_PAYMENT.getValor());
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
}
