package com.usaa.ecag.gdapi;

public class SendMessage {

	@Override
	public String toString() {
		return "SendMessage [message=" + message + "]";
	}

	public SendMessage(String string) {
		message=string;
	}

	String message;
}
