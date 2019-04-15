package trying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author Jinwook
 * 목표 : 엔터 치면 패킷 하나씩 날라가는 프로그램
 * 혹은, 파일을 일정 크기로 잘라 보냄.
 */
public class UDPClient {
	public LinkedList<Thread> tList;
	
	public UDPClient() {
		this.tList = new LinkedList<Thread>();
	}
	/** 
	 * @param addr
	 * @param port
	 * @param msg
	 * 해당하는 address에 해당하는 port로 패킷을 보낸다. 실제로 패킷을 보내는 메소드
	 */
	public void send(String addr, int port, String msg) {
		try{
			InetAddress inetAddr = InetAddress.getByName(addr);
			DatagramSocket dsock = new DatagramSocket();
			DatagramPacket dpack = new DatagramPacket(msg.getBytes(), msg.getBytes().length, inetAddr, port);
		} catch(UnknownHostException e) {
			System.out.println("Error: unknown address or ip");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String recv(int port, DatagramSocket dsock) {
		return null;
	}
	public String recv(int port) {
		try {
			return recv(port, new DatagramSocket(port));
		} catch (SocketException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 */
	public void joinAll() {
		Iterator<Thread> it = this.tList.iterator();
		while (it.hasNext()) {
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
