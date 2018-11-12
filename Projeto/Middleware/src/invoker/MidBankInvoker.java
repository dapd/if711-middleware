package invoker;

import handlers.ServerRequestHandler;
import message.Message;
import message.MessageBody;
import message.MessageHeader;
import message.ReplyBody;
import message.ReplyHeader;
import middleware.MidBankImpl;
import proxy.ClientProxy;
import proxy.Marshaller;

public class MidBankInvoker {

	private static final String REQUEST = "request";

	public void invoker(ClientProxy clientProxy) throws Exception {
		ServerRequestHandler handler = new ServerRequestHandler(clientProxy.getPort());
		byte[] msgSerializada = null;
		byte[] msgASerSerializada = null;	
		Message msgNaoSerial = new Message();
		MidBankImpl txtRepoImpl = new MidBankImpl();
		Marshaller marshaller = new Marshaller();
		
		while (Boolean.TRUE) {
			msgSerializada = handler.receive();
			msgNaoSerial = marshaller.unmarshall(msgSerializada);
			if (REQUEST.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				msgASerSerializada = txtRepoImpl.request((String) msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				Message sendMessage = new Message(new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length), new MessageBody(null, null, new ReplyHeader("fileOk", 0, 0), new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage));
			} else {
				throw new Exception("NotReconizedException");
			}
			
		}
	}
	
}
