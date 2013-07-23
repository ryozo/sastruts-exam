package sastruts.exam.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.container.filter.S2ContainerFilter;
import org.seasar.struts.util.RequestUtil;

/**
 * Webサービス利用において作成されるSessionを通信終了時にInvalidateするためのマークを設定するインターセプタです。
 * @author W.Ryozo
 * @version 1.0
 */
public class WebServiceSessionInvalidMarkInterceptor extends AbstractInterceptor{
    
    /**
     * 通信終了時にSessionをInvalidateするようマークします。<br />
     * 当設定により、通信終了時{@link S2ContainerFilter}によって、Sessionが廃棄されます。
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        RequestUtil.getRequest().setAttribute(S2ContainerFilter.INVALIDATE_SESSION, Boolean.TRUE);
        return invocation.proceed();
    }

}
