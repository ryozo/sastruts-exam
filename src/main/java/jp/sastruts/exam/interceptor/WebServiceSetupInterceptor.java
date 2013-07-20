package jp.sastruts.exam.interceptor;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import jp.sastruts.exam.dto.ServiceXmlStoreDto;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.util.ArrayUtil;
import org.seasar.struts.util.RequestUtil;

/**
 * Webサービスの初期処理を行うインターセプタです。
 * @author W.Ryozo
 *
 */
public class WebServiceSetupInterceptor extends AbstractInterceptor {
	
	Logger logger = Logger.getLogger(WebServiceSetupInterceptor.class);
	
	@Resource
	public ServiceXmlStoreDto serviceXmlStoreDto;
	
	/**
	 * 初期処理を行います。
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		HttpServletRequest request = RequestUtil.getRequest();
		ServletInputStream stream = request.getInputStream();
		
		byte[] buf = new byte[4096];
		List<Byte> xmlByteArray = new ArrayList<Byte>();

		int readByte;
		while((readByte = stream.read(buf)) != -1) {
			xmlByteArray.addAll(ArrayUtil.toList(buf));
			logger.info("読み込みサイズ : " + readByte);
		}
		
		byte[] xml = new byte[xmlByteArray.size()];
		for (int i = 0; i < xmlByteArray.size(); i++) {
			xml[i] = xmlByteArray.get(i).byteValue();
		}
		
		// TODO Session削除のマーク
		
		serviceXmlStoreDto.xml = xml;
		
		return invocation.proceed();
	}

}
