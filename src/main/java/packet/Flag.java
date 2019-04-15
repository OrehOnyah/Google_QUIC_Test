package packet;

/**
 * 
 * @author Jung Jinwook
 *
 * flag들을 모아 두는 
 */
public enum Flag {

	PUBLIC_FLAG_VERSION(1),
	PUBLIC_FLAG_RESET(2),
	NOUNCE_32(4),
	CID_LENGTH_8(8),
	PACKET_NUMBER_LENGTH_1(0),
	PACKET_NUMBER_LENGTH_2(16),
	PACKET_NUMBER_LENGTH_4(32),
	PACKET_NUMBER_LENGTH_6(48),
	MULTIPATH(64)/*,
	CURRENTLY_UNUSED(128)*/;
	
	private int value;
	private Flag(int value) {
		this.value = value;
	}
	public int value() {
		return this.value;
	}
}
