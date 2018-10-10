package message;

import java.io.Serializable;

public class MessageHeader implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9159746341141521538L;
	private String magic;
	private int version;
	private boolean byteOrder;
	private int messageType;
	private long messageSize;
	
	
	
	/**
	 * @param magic
	 * @param version
	 * @param byteOrder
	 * @param messageType
	 * @param messageSize
	 */
	public MessageHeader(String magic, int version, boolean byteOrder, int messageType, long messageSize) {
		super();
		this.magic = magic;
		this.version = version;
		this.byteOrder = byteOrder;
		this.messageType = messageType;
		this.messageSize = messageSize;
	}
	/**
	 * @return the magic
	 */
	public String getMagic() {
		return magic;
	}
	/**
	 * @param magic the magic to set
	 */
	public void setMagic(String magic) {
		this.magic = magic;
	}
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	/**
	 * @return the byteOrder
	 */
	public boolean isByteOrder() {
		return byteOrder;
	}
	/**
	 * @param byteOrder the byteOrder to set
	 */
	public void setByteOrder(boolean byteOrder) {
		this.byteOrder = byteOrder;
	}
	/**
	 * @return the messageType
	 */
	public int getMessageType() {
		return messageType;
	}
	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	/**
	 * @return the messageSize
	 */
	public long getMessageSize() {
		return messageSize;
	}
	/**
	 * @param messageSize the messageSize to set
	 */
	public void setMessageSize(long messageSize) {
		this.messageSize = messageSize;
	}
}
