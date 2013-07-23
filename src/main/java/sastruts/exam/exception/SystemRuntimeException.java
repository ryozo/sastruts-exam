package sastruts.exam.exception;

/**
 * 再起不能なエラーが発生した場合にThrowされるException
 * @author W.Ryozo
 * @version 1.0
 */
public class SystemRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public SystemRuntimeException() {
		super();
	}
	
	public SystemRuntimeException(String message) {
		super(message);
	}
	
	public SystemRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SystemRuntimeException(Throwable cause) {
		super(cause);
	}

}
