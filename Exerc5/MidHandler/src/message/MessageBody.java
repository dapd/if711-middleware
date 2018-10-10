package message;

import java.io.Serializable;

public class MessageBody implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1694389555503409000L;
	private RequestHeader requestHeader;
	private RequestBody requestBody;
	private ReplyHeader replyHeader;
	private ReplyBody replyBody;
	
	
	/**
	 * @param requestHeader
	 * @param requestBody
	 * @param replyHeader
	 * @param replyBody
	 */
	public MessageBody(RequestHeader requestHeader, RequestBody requestBody, ReplyHeader replyHeader,
			ReplyBody replyBody) {
		super();
		this.requestHeader = requestHeader;
		this.requestBody = requestBody;
		this.replyHeader = replyHeader;
		this.replyBody = replyBody;
	}
	/**
	 * @return the requestHeader
	 */
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}
	/**
	 * @param requestHeader the requestHeader to set
	 */
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}
	/**
	 * @return the requestBody
	 */
	public RequestBody getRequestBody() {
		return requestBody;
	}
	/**
	 * @param requestBody the requestBody to set
	 */
	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}
	/**
	 * @return the replyHeader
	 */
	public ReplyHeader getReplyHeader() {
		return replyHeader;
	}
	/**
	 * @param replyHeader the replyHeader to set
	 */
	public void setReplyHeader(ReplyHeader replyHeader) {
		this.replyHeader = replyHeader;
	}
	/**
	 * @return the replyBody
	 */
	public ReplyBody getReplyBody() {
		return replyBody;
	}
	/**
	 * @param replyBody the replyBody to set
	 */
	public void setReplyBody(ReplyBody replyBody) {
		this.replyBody = replyBody;
	}
}

