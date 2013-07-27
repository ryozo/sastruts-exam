package sastruts.exam.dto;

/**
 * Webサービスで利用するXml情報を保持するDtoです。<br />
 * 当クラスはよりHTTPに近い形式でRequest、Response情報を保持します。
 * @author W.Ryozo
 * @version 1.0
 */
public class ServiceXmlStoreDto {
	
    /** RequestのBODY部分です。 */
	public byte[] requestBodyBytes;
	
	/** ResponseのBODY部分です */
	public String responseBody;

}
