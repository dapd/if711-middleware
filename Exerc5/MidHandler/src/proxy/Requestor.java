package proxy;

import handlers.ClientRequestHandler;
import message.Message;

public class Requestor {
	private ClientRequestHandler crh = new ClientRequestHandler("localhost", 1234);
	
	/*
	public Termination invoke(Invocation req) throws UnknownHostException, IOException, Throwable{
		
	}
	public Termination invoke(Invocation inv) throws UnknownHostException, IOException, Throwable{
		
		ClientRequestHandler crh = new ClientRequestHandler(inv.getClientProxy().getHost(), inv.getClientProxy().getPort());
		
		Marshaller marshaller = new Marshaller();
		Termination termination = new Termination();
		byte [] msgMarshalled;
		byte [] msgToBeUnmarshalled;
		Message msgUnmarshalled = new Message();
		
		//map Invocation into a Message
		RequestHeader requestHeader = new RequestHeader("",0,true,0,inv.getOperationName());
		RequestBody requestBody = new RequestBody(inv.getParameters());
		MessageHeader messageHeader = new MessageHeader("MIOP",0,false,0,0);
		MessageBody messageBody = new MessageBody(requestHeader, requestBody,null,null);
		Message msgToBeMarshalled = new Message(messageHeader,messageBody);
		
		//marshall request message
		msgMarshalled = marshaller.marshall(msgToBeMarshalled);
		
		//send marshalled message
		crh.send(msgMarshalled;)
		
		msgToBeUnmarshalled = marshaller.unmarshall(msgToBeUnmashalled);
		
		//return result to Client Proxy
		termination.setResult(msgUnmarshalled.getBody().getReplyBody().getOperationResult());
		
		return termination;
		
		
		
	};
	
	*/
	
}
