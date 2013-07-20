package jp.sastruts.exam.interceptor;

import javax.annotation.Resource;

import jp.sastruts.exam.dto.ServiceXmlStoreDto;
import jp.sastruts.exam.exception.ApplicationRuntimeException;
import jp.sastruts.exam.service.dto.LogInfo;

/**
 * Webサービス関連のログを取得するためのインターセプタです。
 * @author W.Ryozo
 *
 */
public class WebServiceLogInterceptor extends LogInterceptorBase {

	@Resource
	public ServiceXmlStoreDto serviceXmlStoreDto;
	
	@Override
	protected LogInfo preLog(LogInfo logInfo) {
		String xmlString = null;
		try {
			// TODO　文字コードの考慮
			xmlString = new String(serviceXmlStoreDto.xml, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		logInfo.preInfo = xmlString;
		return logInfo;
	}	
	
	@Override
	protected LogInfo postLog(LogInfo logInfo) {
		logInfo.postInfo = "serviceend";
		return logInfo;
	}
	
}
