package jp.sastruts.exam.interceptor;

import java.io.BufferedReader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.sastruts.exam.dto.ServiceXmlStoreBean;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.util.RequestUtil;

/**
 * Webサービスの初期処理を行うインターセプタです。
 * @author W.Ryozo
 *
 */
public class WebServiceSetupInterceptor extends AbstractInterceptor {
	
	@Resource
	public ServiceXmlStoreBean serviceXmlStoreBean;
	
	/**
	 * 初期処理を行います。
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		HttpServletRequest request = RequestUtil.getRequest();
		BufferedReader reader = request.getInputStream();
		reader.read
		return null;
	}

}
