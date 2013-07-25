package sastruts.exam.exception.webservice;

/**
 * Webサービス内で業務的な例外が発生したことを表すRuntimExceptionです。<br />
 * @author W.Ryozo
 * @version 1.0 新規作成
 */

public class ServiceApplicationRuntimeException {

    private String messageCode;
    private Throwable cause;

    public ServiceApplicationRuntimeException(String messageCode) {
        this.messageCode = messageCode;
    }

    public ServiceApplicationRuntimeException(String messageCode, Throwable t) {
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
