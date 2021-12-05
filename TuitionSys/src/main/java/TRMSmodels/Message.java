package TRMSmodels;

import TRMSservices.PersonService;

public class Message {

	int messageID;
	int messageTo;
	int messageFrom;
	int requestID;
	String message;
	String fromName;
	
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public int getMessageID() {
		return messageID;
	}
	public int getMessageTo() {
		return messageTo;
	}
	public int getMessageFrom() {
		return messageFrom;
	}
	public int getRequestID() {
		return requestID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public void setMessageTo(int messageTo) {
		this.messageTo = messageTo;
	}
	public void setMessageFrom(int messageFrom) {
		this.messageFrom = messageFrom;
		this.fromName=PersonService.getPerson(messageFrom).getName();
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Message(int messageID, int messageTo, int messageFrom, int requestID, String message) {
		super();
		this.messageID = messageID;
		this.messageTo = messageTo;
		this.messageFrom = messageFrom;
		this.requestID = requestID;
		this.fromName = PersonService.getPerson(messageFrom).getName();
		this.message = message;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Message [messageID=" + messageID + ", messageTo=" + messageTo + ", messageFrom=" + fromName
				+ ", requestID=" + requestID + ", |||||||Message=" + message + "]\n";
	}

	
	
}
