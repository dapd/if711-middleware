package middleware;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IMidBank extends Remote {
	byte[] createAccout(UUID uniqueId, String pswd, int accountNumber, int bankBranchNumber) throws RemoteException, IOException;
	byte[] login(UUID uniqueId, String pswd) throws RemoteException, IOException;
	byte[] moneyTransfer(int bankBranchNumber, int accountNumber, String bankName, float amountToTransfer, UUID uniqueId) throws RemoteException, IOException;
	byte[] accountBalance(UUID uniqueId) throws RemoteException, IOException;
	byte[] payment (UUID uniqueId, String billNumber) throws RemoteException, IOException;	
	byte[] creditCardBill(UUID uniqueId) throws RemoteException, IOException;
}
