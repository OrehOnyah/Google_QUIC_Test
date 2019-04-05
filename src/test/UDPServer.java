package test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * 
 * @author Jung Jinwook
 *
 */
public class UDPServer {
	public LinkedList<Thread> tList;
	public UDPServer() {
		this.tList = new LinkedList<Thread>();
		
	}
	/**
	 * start server
	 * @param port
	 */
	public void serve(int port) {
		tList.addFirst(new Thread(new Runnable() {
			public int serverport = port;
			@Override
			public void run() {
				try {
					DatagramSocket dsock = new DatagramSocket(this.serverport);
					System.out.println("server waiting : port "+this.serverport);
					String line = null;
					while(true) {
						byte[] buffer = new byte[1024];
						DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
						dsock.receive(receivePacket);
						String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
						System.out.println("get :\n"+msg);
						if(msg.contentEquals("quit")) break;
					}
				} catch (SocketException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));
		tList.peekFirst().run();
	}
	/**
	 * 
	 */
	public void joinAll() {
		Iterator<Thread> it = this.tList.iterator();
		while(it.hasNext()) {
			try {
				it.next().join();
			} catch (InterruptedException e) {
				continue;
			}
		}
	}
	public static void main(String[] args) {
		UDPServer udpserver = new UDPServer();
		udpserver.serve(20443);
	}
}
