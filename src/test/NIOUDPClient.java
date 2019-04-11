package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class NIOUDPClient {
	public static void main(String[] args) {
		ByteBuffer sendBuffer = Charset.forName("UTF-8").encode("한글");
		
		DatagramChannel datagramChannel;
        try {
        	System.out.println("send");
            datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
            datagramChannel.send(sendBuffer,new InetSocketAddress("localhost",9999));
            datagramChannel.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
