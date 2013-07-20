package jp.sastruts.exam.jaxb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import jp.sastruts.exam.annotation.AppXml;
import jp.sastruts.exam.exception.SystemRuntimeException;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.framework.util.ResourceUtil;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;

/**
 * JAXBコンテキストを管理するオブジェクトです。
 * @author W.Ryozo
 * @version 1.0
 */
@Component(instance=InstanceType.SINGLETON)
public class JaxbContextWrapper {

	private JAXBContext context = null;

	private List<Class<?>> TARGET_ELEMENT_LIST = null;
	
	/**
	 * 初期化します。
	 * @param contextPath
	 * @throws JAXBException
	 */
	public void init(String contextPath) throws JAXBException {
		BufferedReader reader = null;
		try {
			URL resourceUrl = ResourceUtil.getResource(contextPath);
			File resourceFile = new File(resourceUrl.toURI());
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(resourceFile)));
			
			List<Class<?>> elementList = new ArrayList<Class<?>>();
			String line;
			while ((line = reader.readLine()) != null) {
				Class<?> currentElement = Class.forName(line);
				if (!currentElement.isAnnotationPresent(AppXml.class)) {
					// XMLRootエレメントアノテーションを保持しない場合、エラーとする。
					throw new SystemRuntimeException("TagクラスにはAppXmlアノテーションが必須です。");
				} else {
					// TODO name属性値の有無確認
				}
				elementList.add(currentElement);
			}
			
			context = JAXBContext.newInstance(elementList.toArray(new Class[0]));
			TARGET_ELEMENT_LIST = Collections.unmodifiableList(elementList);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {}
			}
		}
	}
	
	/**
	 * Unmarshallerを取得します。
	 * @return
	 */
	public Unmarshaller getUnmarshaller() {
		try {
			return context.createUnmarshaller();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Marshallerを取得します。
	 * @return
	 */
	public Marshaller getMarshaller() {
		try {
			return context.createMarshaller();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 当システムがサポートするすべてのタグクラスを保持するListを返却します。
	 * @return タグクラスを保持するList
	 */
	public List<Class<?>> getTargetElementList() {
		return TARGET_ELEMENT_LIST;
	}
	
}
