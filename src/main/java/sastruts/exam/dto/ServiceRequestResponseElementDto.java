package sastruts.exam.dto;

import sastruts.exam.element.com.RootTag;

/**
 * Webサービス利用におけるRequest、およびResponseのタグ情報を保持するためのDtoです。<br />
 * 各実装者は当クラスをDIし、{@link #requestTag}よりリクエストされたXML情報を取得してください。<br />
 * レスポンス情報は{@link #responseTag}に対して設定してください。
 * @author W.Ryozo
 * @version 1.0
 */
public class ServiceRequestResponseElementDto {

    /** リクエストされたTag*/
    public RootTag requestTag;

    /** レスポンスとして返却するTag */
    public RootTag responseTag;
}
