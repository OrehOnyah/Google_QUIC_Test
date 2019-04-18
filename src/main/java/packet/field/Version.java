package packet.field;

import java.nio.ByteBuffer;

import lombok.Getter;
import packet.Field;

public class Version extends Field {
	public static final int IETF_DRAFT_19 = 0xff000013;
	public static final int DEFAULT_VERSION = IETF_DRAFT_19;
	
	@Getter
	private byte[] version;
	public Version() {
		super.setLength(32);
		ByteBuffer version = ByteBuffer.allocate(Integer.BYTES);
		version.putInt(DEFAULT_VERSION);
		this.version = version.array();
	}
	
}
