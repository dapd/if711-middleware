package middleware;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MidBankImpl extends UnicastRemoteObject implements IMidBank {

	private static final long serialVersionUID = 1L;

	private static final String BANK_NAME = "MidBank";

	private Map<Integer, Account> accounts = new Hashtable<>();

	private Map<Integer, Double> saldos = new Hashtable<Integer, Double>();

	private List<Transaction> historic = new ArrayList<>();

	private List<String> payments = new ArrayList<>();

	public MidBankImpl() throws RemoteException {
		super();
	}

	@Override
	public byte[] createAccout(UUID uniqueId, String pswd, int accountNumber, int bankBranchNumber)
			throws RemoteException, IOException {
		String ret;
		Account newAccount = new Account(uniqueId.toString(), pswd, accountNumber, bankBranchNumber,
				UUID.randomUUID().toString());
		if (!accounts.containsValue(newAccount)) {
			accounts.put(accountNumber, newAccount);
			saldos.put(accountNumber, 0.0);
			historic.add(new Transaction(UUID.randomUUID().toString(), Operation.ACCOUNT_CREATION.getValor(), null,
					new Date().toString()));
			ret = Messages.SCS.getValor();
		} else {
			ret = Messages.INVALID_ACCOUNT.getValor();
		}
		return ret.getBytes();
	}

	@Override
	public byte[] login(UUID uniqueId, String pswd) throws RemoteException, IOException {

		return Messages.SCS.getValor().getBytes();
	}

	@Override
	public byte[] moneyTransfer(UUID uniqueId, Integer debitAccountNumber, Integer debitBankBranchNumber,
			Integer creditAccountNumber, Integer creditBankBranchNumber, String bankName, Double amountToTransfer)
			throws RemoteException, IOException {
		String ret;
		if (saldos.getOrDefault(debitAccountNumber, 0.0) > 0.0) {
			if (BANK_NAME.equals(bankName)) {
				if (saldos.containsKey(creditAccountNumber)) {
					Double debit = saldos.get(debitAccountNumber);
					Double credit = saldos.get(creditAccountNumber);
					credit += amountToTransfer;
					debit -= amountToTransfer;
					saldos.put(creditAccountNumber, credit);
					saldos.put(debitAccountNumber, debit);
					historic.add(new Transaction(UUID.randomUUID().toString(), Operation.TRANSFER.getValor(), null,
							new Date().toString()));
					ret = Messages.SCS.getValor();
				} else {
					ret = Messages.INVALID_CREDIT_ACCOUNT.getValor();
				}
			} else {
				historic.add(new Transaction(UUID.randomUUID().toString(), Operation.TRANSFER.getValor(), null,
						new Date().toString()));
				ret = Messages.SCS.getValor();
			}
		} else {
			ret = Messages.NO_BALANCE.getValor();
		}
		return ret.getBytes();
	}

	@Override
	public byte[] accountBalance(UUID uniqueId, Integer accountNumber) throws RemoteException, IOException {
		String ret;
		if (saldos.containsKey(accountNumber)) {
			ret = saldos.get(accountNumber).toString();
			historic.add(new Transaction(UUID.randomUUID().toString(), Operation.BALANCE.getValor(), null,
					new Date().toString()));
		} else {
			ret = Messages.INVALID_ACCOUNT.getValor();
		}
		return ret.getBytes();
	}

	@Override
	public byte[] payment(UUID uniqueId, Integer accountNumber, String billNumber, Double value)
			throws RemoteException, IOException {
		return doPayment(accountNumber, billNumber, value);
	}

	@Override
	public byte[] creditCardBill(UUID uniqueId, Integer accountNumber, Double value)
			throws RemoteException, IOException {

		byte[] ret;
		if (accounts.containsKey(accountNumber)) {
			String billNumber = accounts.get(accountNumber).getCardId() + new Date().toString();
			ret = doPayment(accountNumber, billNumber, value);
		} else {
			ret = Messages.INVALID_ACCOUNT.getValor().getBytes();
		}
		return ret;
	}

	private byte[] doPayment(Integer accountNumber, String billNumber, Double value) {
		String ret;
		if (payments.contains(billNumber)) {
			ret = Messages.INVALID_PAYMENT.getValor();
		}
		if (accountNumber == null) {
			ret = Messages.INVALID_ACCOUNT.getValor();
		} else if (!saldos.containsKey(accountNumber)) {
			ret = Messages.INVALID_ACCOUNT.getValor();
		} else if (saldos.get(accountNumber) <= 0.0) {
			ret = Messages.NO_BALANCE.getValor();
		} else {
			payments.add(billNumber);
			historic.add(new Transaction(UUID.randomUUID().toString(), Operation.PAYMENT.getValor(), value.toString(),
					new Date().toString()));
			ret = Messages.SCS.getValor();
		}
		return ret.getBytes();
	}

}
