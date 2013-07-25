package sastruts.exam.exception.browse;

/**
 * ブラウザベースの業務アプリケーションで再起不能な例外が発生したことを表すRuntimExceptionです。
 * @author W.Ryozo
 * @version 1.0 新規作成
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
