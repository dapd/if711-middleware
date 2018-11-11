package message;

import java.io.Serializable;

public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4017682470493420020L;
	private MessageHeader header;
	private MessageBody body;
	
	
	/**
	 * 
	 */
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param header
	 * @param body
	 */
	public Message(MessageHeader header, MessageBody body) {
		super();
		this.header = header;
		this.body = body;
	}
	/**
	 * @return the header
	 */
	public MessageHeader getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(MessageHeader header) {
		this.header = header;
	}
	/**
	 * @return the body
	 */
	public MessageBody getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(MessageBody body) {
		this.body = body;
	}
}
