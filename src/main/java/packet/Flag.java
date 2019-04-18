package packet;

/**
 * 
 * @author Jung Jinwook
 *
 * flag들을 모아 두는 
 */
public class Flag extends Field{
	
	public static final int PUBLIC_FLAG_VERSION = 1;
	public static final int PUBLIC_FLAG_RESET=2;
	public static final int NOUNCE_32=4;
	public static final int CID_LENGTH_8=8;
	public static final int PACKET_NUMBER_LENGTH_1=0;
	public static final int PACKET_NUMBER_LENGTH_2=16;
	public static final int PACKET_NUMBER_LENGTH_4=32;
	public static final int PACKET_NUMBER_LENGTH_6=48;
	public static final int MULTIPATH=64;
	/*CURRENTLY_UNUSED(128)*/
	
	private int value;
	public Flag(int value) {
		super.setLength(8);
		this.value = value;
	}
	public int value() {
		return this.value;
	}
}
