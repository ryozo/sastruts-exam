package sastruts.exam.element.com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import sastruts.exam.annotation.AppXml;
import sastruts.exam.annotation.AppXmlType;

/**
 * 各種管理情報を保持する共通タグ
 * @author W.Ryozo
 * @version 1.0
 */
@AppXml(type=AppXmlType.COMMON)
@XmlRootElement(name = "common")
public class CommonTag extends Tag {

	/** SerialVersionUID */
	public static final long serialVersionUID = 1L;

	/** SessionKey **/
	@XmlElement(name="sessionKey")
	public String sessionKey;

	/** 日時情報 TODO java.util.Dateでの実装と検証 */
	@XmlElement(name="dateTime")
	public String dateTime;

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
	}

}
