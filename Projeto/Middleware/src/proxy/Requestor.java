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
	private static final long TIMEOUT = 30000l;
	private static final Random RANDOM = new Random(System.currentTimeMillis());

	public byte[] invoke(Invocation invok) throws UnknownHostException {
		ClientRequestHandler crh = new ClientRequestHandler(invok.getHost(), invok.getPort());
		Marshaller marshaller = new Marshaller();
		Boolean communicationSuccess = Boolean.TRUE;

		Message request = new Message(
				new MessageHeader("ftp", 0, Boolean.FALSE, 0,
						invok.getOperationName().length() + invok.getParameters().size()),
				new MessageBody(new RequestHeader("", RANDOM.nextInt(), Boolean.TRUE, invok.getObjectId(),
						invok.getOperationName()), new RequestBody(invok.getParameters()), null, null));

		Long inicialTime = System.currentTimeMillis();
		Long finalTime = 0l;
		byte[] bs = null;

		do {
			try {
				byte[] serialMessage = marshaller.marshall(request);
				crh.send(serialMessage);
				bs = crh.receive();
				communicationSuccess = Boolean.TRUE;
			} catch (IOException | InterruptedException | NotBoundException e) {
				e.printStackTrace();
				communicationSuccess = Boolean.FALSE;
				finalTime = System.currentTimeMillis();
				if (!communicationSuccess && finalTime - inicialTime > TIMEOUT) {
					break;
				}
			}
		} while (!communicationSuccess);

		return bs;
	}
}
