package invoker;

import java.util.UUID;

import handlers.ServerRequestHandler;
import message.Message;
import message.MessageBody;
import message.MessageHeader;
import message.ReplyBody;
import message.ReplyHeader;
import middleware.MidBankImpl;
import middleware.Operation;
import proxy.ClientProxy;
import proxy.Marshaller;

public class MidBankInvoker {

	public void invoker(ClientProxy clientProxy) throws Exception {
		ServerRequestHandler handler = new ServerRequestHandler(clientProxy.getPort());
		byte[] msgSerializada = null;
		byte[] msgASerSerializada = null;
		Message msgNaoSerial = new Message();
		MidBankImpl midBankImpl = new MidBankImpl();
		Marshaller marshaller = new Marshaller();

		while (Boolean.TRUE) {
			msgSerializada = handler.receive();
			msgNaoSerial = marshaller.unmarshall(msgSerializada);
			if (Operation.ACCOUNT_CREATION.getValor()
					.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				String pswd = msgNaoSerial.getBody().getRequestBody().getParameters().get(1);
				Integer accountNumber = Integer.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(2));
				Integer bankBranchNumber = Integer
						.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(3));
				msgASerSerializada = midBankImpl.createAccout(id, pswd, accountNumber, bankBranchNumber);
				Message sendMessage = new Message(
						new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
						new MessageBody(null, null, new ReplyHeader(Operation.ACCOUNT_CREATION.getValor(), 0, 0),
								new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage));
			} else {
				throw new Exception("NotReconizedException");
			}

			if (Operation.LOGIN.getValor().equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				String pswd = msgNaoSerial.getBody().getRequestBody().getParameters().get(1);
				msgASerSerializada = midBankImpl.login(id, pswd);
				Message sendMessage = new Message(
						new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
						new MessageBody(null, null, new ReplyHeader(Operation.LOGIN.getValor(), 0, 0),
								new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage));
			} else {
				throw new Exception("NotReconizedException");
			}

			if (Operation.TRANSFER.getValor().equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				Integer debitAccountNumber = Integer
						.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(1));
				Integer debitBankBranchNumber = Integer
						.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(2));
				Integer creditAccountNumber = Integer
						.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(3));
				Integer creditBankBranchNumber = Integer
						.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(4));
				String bankName = msgNaoSerial.getBody().getRequestBody().getParameters().get(5);
				Double amountToTransfer = Double
						.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(6));
				msgASerSerializada = midBankImpl.moneyTransfer(id, debitAccountNumber, debitBankBranchNumber,
						creditAccountNumber, creditBankBranchNumber, bankName, amountToTransfer);
				Message sendMessage = new Message(
						new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
						new MessageBody(null, null, new ReplyHeader(Operation.TRANSFER.getValor(), 0, 0),
								new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage));
			} else {
				throw new Exception("NotReconizedException");
			}

			if (Operation.BALANCE.getValor().equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				Integer accountNumber = Integer.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(1));
				msgASerSerializada = midBankImpl.accountBalance(id, accountNumber);
				Message sendMessage = new Message(
						new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
						new MessageBody(null, null, new ReplyHeader(Operation.BALANCE.getValor(), 0, 0),
								new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage));
			} else {
				throw new Exception("NotReconizedException");
			}

			if (Operation.PAYMENT.getValor().equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				Integer accountNumber = Integer.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(1));
				String billNumber = msgNaoSerial.getBody().getRequestBody().getParameters().get(2);
				Double value = Double.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(3));
				msgASerSerializada = midBankImpl.payment(id, accountNumber, billNumber, value);
				Message sendMessage = new Message(
						new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
						new MessageBody(null, null, new ReplyHeader(Operation.PAYMENT.getValor(), 0, 0),
								new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage));
			} else {
				throw new Exception("NotReconizedException");
			}

			if (Operation.CARD_BILL_PAYMENT.getValor()
					.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				Integer accountNumber = Integer.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(1));
				Double value = Double.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(2));
				msgASerSerializada = midBankImpl.creditCardBill(id, accountNumber, value);
				Message sendMessage = new Message(
						new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
						new MessageBody(null, null, new ReplyHeader(Operation.CARD_BILL_PAYMENT.getValor(), 0, 0),
								new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage));
			} else {
				throw new Exception("NotReconizedException");
			}
		}
	}
}
