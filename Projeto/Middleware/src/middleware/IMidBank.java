package middleware;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IMidBank extends Remote {
	byte[] createAccout(UUID uniqueId, String pswd, int accountNumber, int bankBranchNumber) throws RemoteException, IOException;
	byte[] login(UUID uniqueId, String pswd) throws RemoteException, IOException;
	byte[] moneyTransfer(UUID uniqueId, Integer debitAccountNumber, Integer debitBankBranchNumber, Integer creditAccountNumber, Integer creditBankBranchNumber, String bankName, Double amountToTransfer) throws RemoteException, IOException;
	byte[] accountBalance(UUID uniqueId, Integer accountNumber) throws RemoteException, IOException;
	byte[] payment (UUID uniqueId, Integer accountNumber, String billNumber, Double value) throws RemoteException, IOException;	
	byte[] creditCardBill(UUID uniqueId, Integer accountNumber, Double value) throws RemoteException, IOException;
}
