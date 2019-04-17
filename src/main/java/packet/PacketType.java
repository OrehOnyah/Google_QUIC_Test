package packet;

public enum PacketType {
	VERSION_NEGOTIATION_PACKET,
	PUBLIC_RESET_PACKET,
	REGUALAR_PACKET,
	FRAME_PACKET,
	FEC_PACKET;
	/**
	 * 임시로 구현한 내용.
	 * 추후 타입에 따라서 서로 다른 패킷을 리턴하도록 바꿔야 함.
	 * @return 임시로 추가된 퀵 패킷
	 */
	public QUICPacket getPacket() {
		return new QUICPacket();
	}
}
