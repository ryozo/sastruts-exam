package jp.sastruts.exam.element.com;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * ルートタグを表すクラスです。<br />
 * ルートタグは以下の要素を保持します。<br />
 * 当タグはXML解析後、Sessionスコープに格納され、個々の業務で利用されます。
 * <ul>
 *   <li>commonタグ - 全XMLで共通的に利用する共通タグ。内部に各種管理要素を含む</li>
 *   <li>bizタグ - 個々の業務情報を保持するタグ。</li>
 * </ul>
 * @author W.Ryozo
 *
 */
@Component(instance=InstanceType.SESSION)
public class RootTag extends Tag {

	/** SerialVersionUID */
	public static final long serialVersionUID = 1L;

	/** CommonTag */
	public CommonTag common;

	/**
	 * 個々の業務を表すタグ。{@link AbstractBizTag}はAbstractであり、
	 * 実際は個々の業務が利用するタグ情報を格納する。
	 */
	public AbstractBizTag business;

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
	}
}
