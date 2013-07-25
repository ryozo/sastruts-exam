package sastruts.exam.interceptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.util.RequestUtil;

import sastruts.exam.dto.ServiceXmlStoreDto;
import sastruts.exam.exception.browse.SystemRuntimeException;

/**
 * Webサービスとして利用された場合に、HTTPBodyの読み込みを行うインターセプタです。
 * @author W.Ryozo
 * @version 1.0
 */
public class WebServiceRequestAcquisitionInterceptor extends AbstractInterceptor {

    Logger logger = Logger.getLogger(WebServiceRequestAcquisitionInterceptor.class);

    @Resource
    public ServiceXmlStoreDto serviceXmlStoreDto;

    /**
     * HttpRequestのBody部分をByte配列とし、{@link ServiceXmlStoreDto}上に格納します。
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        ServletInputStream stream = null;
        try {
            stream = RequestUtil.getRequest().getInputStream();
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

            byte[] buff = new byte[1024];
            int read;
            while ((read = stream.read(buff)) != -1) {
                byteStream.write(buff, 0, read);
            }

            serviceXmlStoreDto.xml = byteStream.toByteArray();

        } catch (IOException ioe) {
            throw new SystemRuntimeException(ioe);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ioe) {
                }
            }
        }
        return invocation.proceed();
    }

}
