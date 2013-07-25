package sastruts.exam.jaxb;

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

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.framework.util.ResourceUtil;

import sastruts.exam.annotation.AppXml;
import sastruts.exam.exception.browse.SystemRuntimeException;

/**
 * JAXBコンテキストを管理するオブジェクトです。
 * @author W.Ryozo
 * @version 1.0
 */
@Component(instance = InstanceType.SINGLETON)
public class JaxbContextWrapper {

    private JAXBContext context = null;

    private List<Class<?>> targetElementList = null;

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
                    throw new SystemRuntimeException("Jaxbが担当するElementクラスはAppXmlアノテーションが必須です。");
                } else if (!currentElement.isAnnotationPresent(XmlRootElement.class)) {
                    throw new SystemRuntimeException("Jaxbが担当するElementクラスはXmlRootElementアノテーションが必須です。");
                }
                elementList.add(currentElement);
            }

            context = JAXBContext.newInstance(elementList.toArray(new Class[0]));
            targetElementList = Collections.unmodifiableList(elementList);

        } catch (Exception e) {
            throw new SystemRuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * {@link Unmarshaller}を返却します。 />
     * 当メソッドが返却する{@link Unmarshaller}はjaxb.indexファイルに記述したクラスのアンマーシャルに対応しています。
     * @return アンマーシャラ
     */
    public Unmarshaller getUnmarshaller() throws JAXBException {
        return context.createUnmarshaller();
    }

    /**
     * {@link Marshaller}を返却します。 />
     * 当メソッドが返却する{@link Marshaller}はjaxb.indexファイルに記述したクラスのアンマーシャルに対応しています。
     * @return マーシャラ
     */
    public Marshaller getMarshaller() throws JAXBException {
        return context.createMarshaller();
    }

    /**
     * 当クラスの{@link JaxbContextWrapper#getMarshaller()}、および{@link JaxbContextWrapper#getUnmarshaller()}が返却する
     * マーシャラ/アンマーシャラが対応するElementクラスの一覧を返却します。<br />
     * 当メソッドが返すElement以外のクラスはマーシャル/アンマーシャルできません。
     * @return Elementクラスを保持するList
     */
    public List<Class<?>> getSupportElementList() {
        return targetElementList;
    }

}
