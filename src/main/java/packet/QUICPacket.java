package packet;

import java.util.ArrayList;
import java.util.List;

import packet.QUICPacket.WrongFlagException;

public class QUICPacket {
	private ArrayList<Flag> flagList;
	private ArrayList<Field>fieldList;
	private boolean binaryDataExists;
	private byte[] data;
	/*constructor*/
	/**
	 * 패킷을 보내기 위해 새로운 패킷을 만들 때 이 생성자를 사용함
	 */
	public QUICPacket() {
		this.flagList = new ArrayList<Flag>();
		this.fieldList = new ArrayList<Field>();
		binaryDataExists = false;
	}
	/**
	 * 받은 패킷을 분석하기 위해 이 생성자를 사용함
	 * @param data
	 */
	public QUICPacket(byte[] data) {
		this.data = data;
		this.flagList = new ArrayList<Flag>();
		this.fieldList = new ArrayList<Field>();
		binaryDataExists = true;
	}
	/*public methods*/
	/**
	 * 플래그를 받음.
	 * 플래그는 Enum Flag 형태로 동일 패키지 내에 선언됨.
	 * 
	 * @param flag
	 * @throws WrongFlagException
	 */
	public void addFlag(Flag flag) throws WrongFlagException {
		if(flag==Flag.PACKET_NUMBER_LENGTH_1 ||
				flag==Flag.PACKET_NUMBER_LENGTH_2 ||
				flag==Flag.PACKET_NUMBER_LENGTH_4 ||
				flag==Flag.PACKET_NUMBER_LENGTH_6) {
			for(Flag tmpflag : flagList) {
				if(tmpflag==Flag.PACKET_NUMBER_LENGTH_1 ||
						tmpflag==Flag.PACKET_NUMBER_LENGTH_2 ||
						tmpflag==Flag.PACKET_NUMBER_LENGTH_4 ||
						tmpflag==Flag.PACKET_NUMBER_LENGTH_6) {
					WrongFlagException e = new WrongFlagException("잘못된 플래그 입력입니다.");
					throw e;
				}
			}
		}
		this.flagList.add(flag);
	}
	/**
	 * 플래그, 필드 등을 모두 입력 후 바이너리 데이터 형태로 만듬.
	 */
	public void pack() {
		
	}
	/**
	 * 바이너리 데이터를 입력하여 객체를 초기화한 후
	 * 플래그, 필드 등을 해석하여 enum list로 만듬.
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
		return this.data;
	}
	/**
	 * 플래그 리스트를 리턴함.
	 * unpack()을 수행한 바이너리 패킷이거나,
	 * 플래그를 함수로 추가한 패킷이어야 함.
	 * @return 플래그 리스트
	 */
	public List<Flag> getFlagList(){
		return this.flagList;
	}
	
	/* private methods*/
	
	/* Exception class*/
	public static class WrongFlagException extends Exception {
		public WrongFlagException(String msg) {
			super(msg);
		}
	}
}
