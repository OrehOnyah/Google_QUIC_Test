package packet;

import java.util.ArrayList;
import java.util.List;


public abstract class QUICPacket {
	private ArrayList<Field>fieldList;
	private byte[] binarydata;
	/*constructor*/
	/**
	 * 패킷을 보내기 위해 새로운 패킷을 만들 때 이 생성자를 사용함
	 */
	public QUICPacket() {
		this.fieldList = new ArrayList<Field>();
	}
	/**
	 * 받은 패킷을 분석하기 위해 이 생성자를 사용함
	 * @param data
	 */
	public QUICPacket(byte[] data) {
		this.binarydata = data;
		this.fieldList = new ArrayList<Field>();
	}
	/*public methods*/
	/**
	 * 플래그, 필드 등을 모두 입력 후 바이너리 데이터 형태로 만듬.
	 */
	public abstract void pack();
	/**
	 * 바이너리 데이터를 입력하여 객체를 초기화한 후
	 * 플래그, 필드 등을 해석하여 enum list로 만듬.
	 * 
	 */
	public void unpack() {
		
	}
	/**
	 * 패킷 바이너리 데이터를 리턴함.
	 * 반드시 바이너리 데이터로 만들어진 객체이거나,
	 * 성공적으로 pack()이 수행된 후 호출해야 함.
	 * @return 패킷 바이너리 데이터
	 */
	public byte[] getBinaryData() {
		return this.binarydata;
	}
	
	/* private methods*/
	
}
