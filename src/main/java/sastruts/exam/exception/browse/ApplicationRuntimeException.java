package sastruts.exam.exception.browse;

/**
 * ブラウザベースの業務アプリケーションで業務的な例外が発生したことを表すRuntimExceptionです。<br />
 * 業務継続可能な例外が発生した場合に当Exceptionをthrowしてください。
 * @author W.Ryozo
 * @version 1.0 新規作成
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
