package proxy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.util.Random;

import handlers.ClientRequestHandler;
import message.Message;
import message.MessageBody;
import message.MessageHeader;
import message.RequestBody;
import message.RequestHeader;

public class Requestor {

	public byte[] invoke(Invocation invok) throws UnknownHostException, IOException, NotBoundException, InterruptedException {
		ClientRequestHandler crh = new ClientRequestHandler(invok.getHost(), invok.getPort());
		Marshaller marshaller = new Marshaller();
		Message request = new Message(
				new MessageHeader("ftp", 0, Boolean.FALSE, 0,
						invok.getOperationName().length() + invok.getParameters().size()),
				new MessageBody(
						new RequestHeader("", new Random(System.currentTimeMillis()).nextInt(), Boolean.TRUE,
								invok.getObjectId(), invok.getOperationName()),
						new RequestBody(invok.getParameters()), null, null));
		crh.send(marshaller.marshall(request), "tcp");
		return crh.receive("tcp");

	}
}
