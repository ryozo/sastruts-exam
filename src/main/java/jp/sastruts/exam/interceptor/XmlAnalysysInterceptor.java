package jp.sastruts.exam.interceptor;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import jp.sastruts.exam.annotation.AppXml;
import jp.sastruts.exam.annotation.AppXmlType;
import jp.sastruts.exam.dto.ServiceXmlStoreDto;
import jp.sastruts.exam.element.com.AbstractBizTag;
import jp.sastruts.exam.element.com.CommonTag;
import jp.sastruts.exam.element.com.RootTag;
import jp.sastruts.exam.jaxb.JaxbContextWrapper;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

/**
 * XMLの解析を行うインターセプタです。
 * @author W.Ryozo
 *
 */
public class XmlAnalysysInterceptor extends AbstractInterceptor {
	
	/** SerialVersionUID */
	private static final long serialVersionUID = 1L;
	
	@Resource
	public ServiceXmlStoreDto serviceXmlStoreDto;
	
	/** JAXBContextのWrapper */
	@Resource
	public JaxbContextWrapper jaxbContextWrapper;
	
	/** 個々のタグのアンマーシャル結果を保持するオブジェクト */
	@Resource
	public RootTag rootTag;
	
	/**
	 * StAXとJAXBを利用し、XMLを解析します。
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		unmarshal();
		try {
			return invocation.proceed();
		} finally {
			
		}
	}
	
	private void unmarshal() throws JAXBException {
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		Unmarshaller unmarshaller = jaxbContextWrapper.getUnmarshaller();

		// TODO XMLEventReaderへの変更
		// TODO XPathは使えないのか？
		XMLStreamReader reader = null;
		BufferedInputStream stream = null;

		try {
			stream = new BufferedInputStream(new ByteArrayInputStream(serviceXmlStoreDto.xml));
			reader = factory.createXMLStreamReader(stream);

			// TODO フィルタの適用。
			// StartElementだけフィルタ
//			StreamFilter filter = new StreamFilter() {
//				@Override
//				public boolean accept(XMLStreamReader reader) {
//					return reader.isStartElement();
//				}
//			};
//			reader = factory.createFilteredReader(reader, filter);

			while (reader.hasNext()) {
				int eventType = reader.next();

				if (eventType == XMLStreamReader.START_ELEMENT) {
					if (isCommonTag(reader)) {
						rootTag.common = (CommonTag)unmarshaller.unmarshal(reader);
						continue;
					}
					
					if (isBusinessTag(reader)) {
						rootTag.business = (AbstractBizTag)unmarshaller.unmarshal(reader);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}

			if (reader != null) {
				try {
					reader.close();
				} catch (XMLStreamException xse) {
					xse.printStackTrace();
				}
			}
		}

	}

	/**
	 * 現在の読み込み位置がアンマーシャル対象のポイントであるか判定する。
	 * @param element 判定対象のタグ
	 * @return 判定結果
	 */
	public boolean isTargetPoint(XMLStreamReader reader) throws Exception{
		// TODO　このメソッドを使ってもっと汎用的にする。
		List<Class<?>> targetElementArray = jaxbContextWrapper.getSupportElementList();
		for (Class<?> clazz : targetElementArray) {
			XmlRootElement rootElm = clazz.getAnnotation(XmlRootElement.class);
			if (rootElm.name().equals(reader.getLocalName()));
			return true;
		}
		
		return false;
	}
	
	/**
	 * 現在の読み取り位置がCommonTagであるか判定します。
	 * @param reader 
	 * @return
	 * @throws Exception
	 */
	public boolean isCommonTag(XMLStreamReader reader) throws Exception {
		List<Class<?>> targetElementArray = jaxbContextWrapper.getSupportElementList();
		for (Class<?> clazz : targetElementArray) {
			AppXml appXml = clazz.getAnnotation(AppXml.class);
			if (AppXmlType.COMMON.equals(appXml.type())) {
				XmlRootElement rootElm = clazz.getAnnotation(XmlRootElement.class);
				// TODO CommonTagは全XML内で１つしかない前提でいいのか？
				return rootElm.name().equals(reader.getLocalName());
			}
		}
		
		return false;
	}

	/**
	 * 現在の読み取り位置がBusinessTagであるか判定します。
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public boolean isBusinessTag(XMLStreamReader reader) throws Exception {
		List<Class<?>> targetElementArray = jaxbContextWrapper.getSupportElementList();
		for (Class<?> clazz : targetElementArray) {
			AppXml appXml = clazz.getAnnotation(AppXml.class);
			if (AppXmlType.BUSINESS.equals(appXml.type())) {
				XmlRootElement rootElm = clazz.getAnnotation(XmlRootElement.class);
				// TODO CommonTagは全XML内で１つしかない前提でいいのか？
				return rootElm.name().equals(reader.getLocalName());
			}
		}

		return false;		
	}
}
