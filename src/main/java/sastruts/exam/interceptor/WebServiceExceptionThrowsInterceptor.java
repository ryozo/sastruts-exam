package sastruts.exam.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.ThrowsInterceptor;

/**
 * Webサービスによる通信におけるExceptionHandlerです。
 * @author W.Ryozo
 * @version 1.0 新規作成
 */
public class WebServiceExceptionThrowsInterceptor extends ThrowsInterceptor {
    
    /**
     * Webサービスにおける通信での例外を補足します。
     * @param t
     * @param invocation
     */
    public void handleThrowblae(Throwable t, MethodInvocation invocation) {
        
    }

}
