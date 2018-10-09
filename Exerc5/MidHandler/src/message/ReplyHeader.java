package message;

import java.io.Serializable;

public class ReplyHeader implements Serializable {
	private String serviceContext;
	private int requestId;
	private int replyStatus;
}
