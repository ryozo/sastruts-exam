package jp.sastruts.exam.interceptor;

import jp.sastruts.exam.service.dto.LogInfo;

/**
 * Webサービス関連のログを取得するためのインターセプタです。
 * @author W.Ryozo
 *
 */
public class WebServiceLogInterceptor extends LogInterceptorBase {

	@Override
	protected LogInfo preLog(LogInfo logInfo) {
		logInfo.preInfo = "servicecall";
		return logInfo;
	}	
	
	@Override
	protected LogInfo postLog(LogInfo logInfo) {
		logInfo.postInfo = "serviceend";
		return logInfo;
	}
	
}
