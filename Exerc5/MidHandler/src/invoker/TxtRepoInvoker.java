/**
 * 
 */
package invoker;

import handlers.ServerRequestHandler;
import message.Message;
import message.MessageBody;
import message.MessageHeader;
import message.ReplyBody;
import message.ReplyHeader;
import middleware.TxtRepoImpl;
import proxy.ClientProxy;
import proxy.Marshaller;

/**
 * @author fabio
 *
 */
public class TxtRepoInvoker {

	private static final String REQUEST = "request";

	public void invoker(ClientProxy clientProxy) throws Exception {
		ServerRequestHandler handler = new ServerRequestHandler(clientProxy.getPort());
		byte[] msgSerializada = null;
		byte[] msgASerSerializada = null;	
		Message msgNaoSerial = new Message();
		TxtRepoImpl txtRepoImpl = new TxtRepoImpl();
		Marshaller marshaller = new Marshaller();
		
		while (Boolean.TRUE) {
			msgSerializada = handler.receive("tcp");
			msgNaoSerial = marshaller.unmarshall(msgSerializada);
			if (REQUEST.equals(msgNaoSerial.getBody().getRequestHeader().getOperation())) {
				msgASerSerializada = txtRepoImpl.request((String) msgNaoSerial.getBody().getRequestBody().getParameters().get(0));
				Message sendMessage = new Message(new MessageHeader("ftp", 0, Boolean.FALSE, 0, msgASerSerializada.length), new MessageBody(null, null, new ReplyHeader("fileOk", 0, 0), new ReplyBody(msgASerSerializada)));
				handler.send(marshaller.marshall(sendMessage), "tcp");
			} else {
				throw new Exception("NotReconizedException");
			}
			
		}
	}
	
}
