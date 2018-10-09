package message;

import java.io.Serializable;

public class MessageHeader implements Serializable{
	private String magic;
	private int version;
	private boolean byteOrder;
	private int messageType;
	private long messageSize;
}
