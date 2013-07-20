package jp.sastruts.exam.element.com;

/**
 * 業務用の共通情報を保持するタグ<br />
 * 各業務は当タグを継承したうえで、個々の業務タグを実装すること。
 * @author W.Ryozo
 * @version 1.0
 */
public abstract class AbstractBizTag extends Tag {

	/** SerialVersionUID */
	public static final long serialVersionUID = 1L;

	/** 業務での処理結果メッセージ */
	public String messageKey;

}
