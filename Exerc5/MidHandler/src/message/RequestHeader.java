package message;

import java.io.Serializable;

public class RequestHeader implements Serializable{
	private String context;
	private int requestId;
	private boolean responseExpected;
	private int objectKey;
	private String operation;
}
