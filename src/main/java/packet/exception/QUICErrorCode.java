package packet.exception;

public enum QUICErrorCode {
	QUIC_NO_ERROR,// There was no error. This is not valid for RST_STREAM frames or CONNECTION_CLOSE frames
	QUIC_STREAM_DATA_AFTER_TERMINATION,// There were data frames after the a fin or reset.
	QUIC_SERVER_ERROR_PROCESSING_STREAM,// There was some server error which halted stream processing.
	QUIC_MULTIPLE_TERMINATION_OFFSETS,// The sender received two mismatching fin or reset offsets for a single stream.
	QUIC_BAD_APPLICATION_PAYLOAD,// The sender received bad application data.
	QUIC_INVALID_PACKET_HEADER,// The sender received a malformed packet header.
	QUIC_INVALID_FRAME_DATA,// The sender received an frame data. The more detailed error codes below are prefered where possible.
	QUIC_INVALID_FEC_DATA,// FEC data is malformed.
	QUIC_INVALID_RST_STREAM_DATA,// Stream rst data is malformed
	QUIC_INVALID_CONNECTION_CLOSE_DATA,// Connection close data is malformed.
	QUIC_INVALID_ACK_DATA,// Ack data is malformed.
	QUIC_DECRYPTION_FAILURE,// There was an error decrypting.
	QUIC_ENCRYPTION_FAILURE,// There was an error encrypting.
	QUIC_PACKET_TOO_LARGE,// The packet exceeded MaxPacketSize.
	QUIC_PACKET_FOR_NONEXISTENT_STREAM,// Data was sent for a stream which did not exist.
	QUIC_CLIENT_GOING_AWAY,// The client is going away (browser close, etc.)
	QUIC_SERVER_GOING_AWAY,// The server is going away (restart etc.)
	QUIC_INVALID_STREAM_ID,// A stream ID was invalid.
	QUIC_TOO_MANY_OPEN_STREAMS,// Too many streams already open.
	QUIC_CONNECTION_TIMED_OUT,// We hit our pre-negotiated (or default) timeout
	QUIC_CRYPTO_TAGS_OUT_OF_ORDER,// Handshake message contained out of order tags.
	QUIC_CRYPTO_TOO_MANY_ENTRIES,// Handshake message contained too many entries.
	QUIC_CRYPTO_INVALID_VALUE_LENGTH,// Handshake message contained an invalid value length.
	QUIC_CRYPTO_MESSAGE_AFTER_HANDSHAKE_COMPLETE,// A crypto message was received after the handshake was complete.
	QUIC_INVALID_CRYPTO_MESSAGE_TYPE,// A crypto message was received with an illegal message tag.
	QUIC_SEQUENCE_NUMBER_LIMIT_REACHED;// Transmitting an additional packet would cause a packet number to be reused.

}
