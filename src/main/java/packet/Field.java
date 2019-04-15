package packet;

public class Field {
	private FieldType fieldType;
	private int length;
	/**
	 * 필드 타입이 CONNECTION_ID 혹은 QUIC_VERSION인 경우에만 이 생성자를 사용
	 * @param fieldType
	 * @throws Exception 
	 */
	public Field(FieldType fieldType) throws Exception {
		this.fieldType = fieldType;
		switch(fieldType) {
		case CONNECTION_ID:
			this.length = 8;
			break;
		case QUIC_VERSION:
			this.length = 4;
			break;
		default:
			throw new Exception("wrong fieldtype");
		}
	}
	/**
	 * 모든 필드 타입에 대해 사용 가능하긴 함.
	 * 그러나 CONNECTION_ID 및 QUIC_VERSION에 대해서는 Field(fieldType)을 사용하는 것이 좋음.
	 * @param fieldType
	 * @param length
	 */
	public Field(FieldType fieldType, int length) {
		this.fieldType = fieldType;
		switch(fieldType) {
		case CONNECTION_ID:
			this.length = 8;
			break;
		case QUIC_VERSION:
			this.length = 4;
			break;
		case DIVERSIFICATION_NONCE:
			this.length = length;
			break;
		case PACKET_NUMBER:
			this.length = length;
			break;
		}
	}
	/**
	 * 필드 타입을 정의함.
	 * @author Jung Jinwook
	 */
	public static enum FieldType{
		CONNECTION_ID,
		QUIC_VERSION,
		DIVERSIFICATION_NONCE,
		PACKET_NUMBER;
	}
}
