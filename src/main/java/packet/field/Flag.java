package packet.field;

import packet.Field;

/**
 * 
 * @author Jung Jinwook
 *
 * flag들을 모아 두는 
 */
public class Flag extends Field{
	
	public static final byte PUBLIC_FLAG_VERSION = 1;
	public static final byte PUBLIC_FLAG_RESET = 2;
	
	public static final byte REVERSED = 4;
	public static final byte CID_LENGTH_8 = 8;
	
	public static final byte INITIAL = 0;
	public static final byte ZERO_RTT = 16;
	public static final byte HANDSHAKE = 32;
	public static final byte RETRY = 48;
	
	public static final byte FIXED_BIT = 64;
	
	public static final byte SHORT_PACKET = 0;
	public static final byte LONG_PACKET = -1;
	
	private byte value;
	public Flag() {
		super.setLength(8);
	}
	public void setFlag(byte flagval) {
		this.value+=flagval;
	}
	public int value() {
		return this.value;
	}
}
