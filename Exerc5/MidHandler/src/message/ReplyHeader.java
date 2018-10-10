package message;

import java.io.Serializable;

public class ReplyHeader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2342544144018128812L;
	private String serviceContext;
	private int requestId;
	private int replyStatus;
	
	/**
	 * @param serviceContext
	 * @param requestId
	 * @param replyStatus
	 */
	public ReplyHeader(String serviceContext, int requestId, int replyStatus) {
		super();
		this.serviceContext = serviceContext;
		this.requestId = requestId;
		this.replyStatus = replyStatus;
	}
	/**
	 * @return the serviceContext
	 */
	public String getServiceContext() {
		return serviceContext;
	}
	/**
	 * @param serviceContext the serviceContext to set
	 */
	public void setServiceContext(String serviceContext) {
		this.serviceContext = serviceContext;
	}
	/**
	 * @return the requestId
	 */
	public int getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	/**
	 * @return the replyStatus
	 */
	public int getReplyStatus() {
		return replyStatus;
	}
	/**
	 * @param replyStatus the replyStatus to set
	 */
	public void setReplyStatus(int replyStatus) {
		this.replyStatus = replyStatus;
	}
}
