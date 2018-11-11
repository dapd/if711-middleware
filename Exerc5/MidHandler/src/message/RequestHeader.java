package message;

import java.io.Serializable;

public class RequestHeader implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2767485180867127887L;
	private String context;
	private int requestId;
	private boolean responseExpected;
	private int objectKey;
	private String operation;
	
	/**
	 * @param context
	 * @param requestId
	 * @param responseExpected
	 * @param objectKey
	 * @param operation
	 */
	public RequestHeader(String context, int requestId, boolean responseExpected, int objectKey, String operation) {
		super();
		this.context = context;
		this.requestId = requestId;
		this.responseExpected = responseExpected;
		this.objectKey = objectKey;
		this.operation = operation;
	}
	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
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
	 * @return the responseExpected
	 */
	public boolean isResponseExpected() {
		return responseExpected;
	}
	/**
	 * @param responseExpected the responseExpected to set
	 */
	public void setResponseExpected(boolean responseExpected) {
		this.responseExpected = responseExpected;
	}
	/**
	 * @return the objectKey
	 */
	public int getObjectKey() {
		return objectKey;
	}
	/**
	 * @param objectKey the objectKey to set
	 */
	public void setObjectKey(int objectKey) {
		this.objectKey = objectKey;
	}
	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
}
