package sastruts.exam.exception;

/**
 * 業務的な例外が発生したことを表すRuntimExceptionです。
 * @author W.Ryozo
 *
 */
public class ApplicationRuntimeException extends RuntimeException {
	
	private String messageCode;
	private Throwable cause;
	
	public ApplicationRuntimeException(String messageCode) {
		this.messageCode = messageCode;
	}
	
	public ApplicationRuntimeException(String messageCode, Throwable t) {
		this.messageCode = messageCode;
		this.cause = t;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public Throwable getCause() {
		return cause;
	}

}
