package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;


public class Message {
	
	public static final int SEGMENTSIZE = 128;
	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;

	// construction a Message with the data provided
	public Message(byte[] data) {
		
		if (data != null && data.length < SEGMENTSIZE){
			this.data = data;
		} else {
			throw new RuntimeException("Incorreect message data");
		}
		
	}

	public byte[] getData() {
		return this.data; 
	}

}
