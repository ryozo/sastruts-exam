package jp.sastruts.exam.action.webservice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

/**
 * Webサービス用のテストアクションクラスです。
 * @author W.Ryozo
 *
 */
public class TestServiceAction {
	
	@Execute(validator=false)
	public String call() {
		HttpServletResponse res = ResponseUtil.getResponse();
		PrintWriter writer = null;
		try {
			writer = res.getWriter();
			writer.write("<root><msg>resp</msg></root>");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (writer != null) writer.close();
		}
		return null;
	}

}
