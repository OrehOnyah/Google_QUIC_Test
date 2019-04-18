package packet;

import packet.type.InitialPacket;
import packet.type.VersionNegotiationPacket;

public enum PacketType {
	VERSION_NEGOTIATION_PACKET,
	INITIAL_PACKET,
	ZERO_RTT_PACKET,
	HANDSHAKE_PACKET,
	RETRY_PACKET,
	SHORT_HEADER_PACKET;
	/**
	 * 임시로 구현한 내용.
	 * 추후 타입에 따라서 서로 다른 패킷을 리턴하도록 바꿔야 함.
	 * @return 임시로 추가된 퀵 패킷
	 */
	public QUICPacket getPacket() {
		if(this == VERSION_NEGOTIATION_PACKET) {
			return new VersionNegotiationPacket();
		}
		return new InitialPacket();
	}
}
