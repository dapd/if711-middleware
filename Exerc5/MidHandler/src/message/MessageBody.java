package message;

import java.io.Serializable;

public class MessageBody implements Serializable{
	private RequestHeader requestHeader;
	private RequestBody requestBody;
	private ReplyHeader replyHeader;
	private ReplyBody replyBody;
}

