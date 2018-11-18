package invoker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

	Map<Integer, Message> messages = new HashMap<>();

	public void invoker(ClientProxy clientProxy) throws Exception {
		ServerRequestHandler handler = new ServerRequestHandler(clientProxy.getPort());
		byte[] msgSerializada = null;
		byte[] msgASerSerializada = null;
		Message sendMessage = null;
		Message msgNaoSerial = new Message();
		MidBankImpl midBankImpl = new MidBankImpl();
		Marshaller marshaller = new Marshaller();
		Boolean failure = Boolean.FALSE;

		while (Boolean.TRUE) {
			try {
				msgSerializada = handler.receive();
				failure = Boolean.FALSE;
			} catch (Exception e1) {
				e1.printStackTrace();
				failure = Boolean.TRUE;
			}

			if (!failure) {
				msgNaoSerial = marshaller.unmarshall(msgSerializada);
				String operation = msgNaoSerial.getBody().getRequestHeader().getOperation();
				Integer requestId = msgNaoSerial.getBody().getRequestHeader().getRequestId();
				Message message = messages.getOrDefault(requestId, null);
				if (message != null) {
					sendMessage = message;
					messages.remove(requestId);
				} else {
					if (Operation.ACCOUNT_CREATION.getValor().equals(operation)) {
						UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
						String pswd = msgNaoSerial.getBody().getRequestBody().getParameters().get(1);
						Integer accountNumber = Integer
								.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(2));
						Integer bankBranchNumber = Integer
								.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(3));
						msgASerSerializada = midBankImpl.createAccout(id, pswd, accountNumber, bankBranchNumber);
						sendMessage = new Message(
								new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
								new MessageBody(null, null,
										new ReplyHeader(Operation.ACCOUNT_CREATION.getValor(), requestId, 0),
										new ReplyBody(msgASerSerializada)));
					} else if (Operation.LOGIN.getValor()
							.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
						UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
						String pswd = msgNaoSerial.getBody().getRequestBody().getParameters().get(1);
						msgASerSerializada = midBankImpl.login(id, pswd);
						sendMessage = new Message(
								new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
								new MessageBody(null, null, new ReplyHeader(Operation.LOGIN.getValor(), requestId, 0),
										new ReplyBody(msgASerSerializada)));
					} else if (Operation.TRANSFER.getValor()
							.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
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
						sendMessage = new Message(
								new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
								new MessageBody(null, null,
										new ReplyHeader(Operation.TRANSFER.getValor(), requestId, 0),
										new ReplyBody(msgASerSerializada)));
					} else if (Operation.BALANCE.getValor()
							.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
						UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
						Integer accountNumber = Integer
								.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(1));
						msgASerSerializada = midBankImpl.accountBalance(id, accountNumber);
						sendMessage = new Message(
								new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
								new MessageBody(null, null, new ReplyHeader(Operation.BALANCE.getValor(), 0, 0),
										new ReplyBody(msgASerSerializada)));
					} else if (Operation.PAYMENT.getValor()
							.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
						UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
						Integer accountNumber = Integer
								.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(1));
						String billNumber = msgNaoSerial.getBody().getRequestBody().getParameters().get(2);
						Double value = Double.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(3));
						msgASerSerializada = midBankImpl.payment(id, accountNumber, billNumber, value);
						sendMessage = new Message(
								new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
								new MessageBody(null, null, new ReplyHeader(Operation.PAYMENT.getValor(), requestId, 0),
										new ReplyBody(msgASerSerializada)));
					} else if (Operation.CARD_BILL_PAYMENT.getValor()
							.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
						UUID id = UUID.fromString(msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
						Integer accountNumber = Integer
								.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(1));
						Double value = Double.valueOf(msgNaoSerial.getBody().getRequestBody().getParameters().get(2));
						msgASerSerializada = midBankImpl.creditCardBill(id, accountNumber, value);
						sendMessage = new Message(
								new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
								new MessageBody(null, null,
										new ReplyHeader(Operation.CARD_BILL_PAYMENT.getValor(), requestId, 0),
										new ReplyBody(msgASerSerializada)));
					} else {
						msgASerSerializada = Operation.UNRECOGNIZED.getValor().getBytes();
						sendMessage = new Message(
								new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length),
								new MessageBody(null, null,
										new ReplyHeader(Operation.UNRECOGNIZED.getValor(), Integer.MIN_VALUE, 0),
										new ReplyBody(msgASerSerializada)));
					}
				}
				try {
					handler.send(marshaller.marshall(sendMessage));
				} catch (IOException e) {
					e.printStackTrace();
					messages.put(requestId, sendMessage);
				}
			}
		}
	}
}
