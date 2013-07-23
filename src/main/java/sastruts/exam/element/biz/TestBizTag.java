package sastruts.exam.element.biz;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import sastruts.exam.annotation.AppXml;
import sastruts.exam.annotation.AppXmlType;
import sastruts.exam.element.com.AbstractBizTag;

/**
 * テスト用の業務タグです。
 * @author W.Ryozo
 * @version 1.0
 */
@AppXml(type=AppXmlType.BUSINESS)
@XmlRootElement(name="testBizTag")
public class TestBizTag extends AbstractBizTag implements Serializable {
	
	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public String bizData;

}
