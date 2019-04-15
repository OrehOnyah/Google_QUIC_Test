package packet;

public enum PacketType {
	VERSION_NEGOTIATION_PACKET,
	PUBLIC_RESET_PACKET,
	REGUALAR_PACKET,
	FRAME_PACKET;
	public QUICPacket getPacket() {
		return new QUICPacket();
	}
}
