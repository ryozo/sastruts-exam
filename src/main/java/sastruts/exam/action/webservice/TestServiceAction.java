package sastruts.exam.action.webservice;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

import sastruts.exam.element.com.RootTag;

/**
 * Webサービス用のテストアクションクラスです。
 * @author W.Ryozo
 *
 */
public class TestServiceAction {
	
	/** 通信されたXMLのアンマーシャル結果を保持するTagオブジェクト */
	@Resource
	public RootTag rootTag;
	
	@Execute(validator=false)
	public String call() {
	    System.out.println(rootTag.getClass().getClassLoader().getClass());
		HttpServletResponse res = ResponseUtil.getResponse();
		res.setContentType("application/xml");
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
