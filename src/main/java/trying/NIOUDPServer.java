package trying;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class NIOUDPServer {
	public static void main(String[] args) {
		//ByteBuffer를 선언. allocateDirect를 통하여 다이렉트 버퍼로 선언함.
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(1024).order(ByteOrder.nativeOrder());
		
		
		System.out.println("운영체제: " + System.getProperty("os.name"));
        System.out.println("네이티브의 바이트 해석 순서: " + ByteOrder.nativeOrder());
        DatagramChannel datagramChannel;
        Selector selector;
        try {
        	System.out.println("DEBUG : 1");
            datagramChannel = DatagramChannel.open();
            datagramChannel.socket().bind(new InetSocketAddress(9999));
			datagramChannel.configureBlocking(false);
	        selector = Selector.open();
	        datagramChannel.register(selector, SelectionKey.OP_READ);

	        while(true) {
	        	System.out.println("DEBUG : 2");
	        	int numKeys = selector.select();
	        	Set<SelectionKey> keys = selector.selectedKeys();
	        	System.out.println("DEBUG : key num : " + numKeys);
	        	Iterator<SelectionKey> it = keys.iterator();
	        	while(it.hasNext()) {
	        		SelectionKey key = it.next();
	        		it.remove();
	        		
	        		DatagramChannel incommingChannel = (DatagramChannel) key.channel();
	        		incommingChannel.receive(directBuffer);
	        		
	        		byte[] bytes = new byte[directBuffer.position()];
	        		directBuffer.flip();
	        		directBuffer.get(bytes);
	        		System.out.println(new String(bytes));
	        		directBuffer.clear();
	        	}
	        	
	        }
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
