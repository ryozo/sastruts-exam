package sastruts.exam.dto;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * Webサービスで利用するXml情報を保持するDtoです。
 * @author W.Ryozo
 *
 */
@Component(instance=InstanceType.SESSION)
public class ServiceXmlStoreDto {
	
	public byte[] xml;

}
