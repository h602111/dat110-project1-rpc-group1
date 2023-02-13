package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		
		rpcmsg = new byte[payload.length+1];
		rpcmsg[0] = rpcid;
		for(int i = 0; i < payload.length; i++){
			rpcmsg[i+1] = payload[i];
			
		}
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		
		int msgLength = rpcmsg.length-1;
		payload = new byte[msgLength];

		for(int i = 0; i < msgLength; i++){
			payload[i] = rpcmsg[i+1];
		}
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		encoded = str.getBytes(StandardCharsets.UTF_8);
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 

		decoded = new String(Arrays.copyOf(data, data.length));
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;

		encoded = new byte[0];

		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		return;
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		encoded = ByteBuffer.allocate(4).putInt(x).array();
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;

		decoded = ByteBuffer.wrap(data).getInt();

		return decoded;
		
	}
}
