package jp.sastruts.exam.interceptor;

import javax.annotation.Resource;

import jp.sastruts.exam.service.LogService;
import jp.sastruts.exam.service.dto.LogInfo;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

/**
 * ログ取得インターセプタの雛形です。
 * @author W.Ryozo
 *
 */
public abstract class LogInterceptorBase extends AbstractInterceptor {
	
	protected boolean exceptionThrowsWhenPrintLog;
	
	@Resource
	protected LogService logService;
	
	/**
	 * ログを取得するためのTemplateMethodです。
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		LogInfo logInfo = new LogInfo();
		logInfo = preLog(logInfo);
		try {
			return invocation.proceed();
		} finally {
			logInfo = postLog(logInfo);
			logService.writeLog(logInfo);
		}
		
	}
	
	/**
	 * 処理の実行前ログを取得します。
	 */
	protected abstract LogInfo preLog(LogInfo logInfo);
	
	/**
	 * 処理の実行後ログを取得します。
	 */
	protected abstract LogInfo postLog(LogInfo logInfo);

}
