package jp.sastruts.exam.exception.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

/**
 * 例外処理を行うExceptionHanlderです。
 * @author W.Ryozo
 *
 */
public class BaseExceptionHandler extends ExceptionHandler {

	Logger logger = Logger.getLogger(BaseExceptionHandler.class);
	
	/**
	 * 例外処理を行います。
	 */
	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {
		logger.error(ex.getMessage(), ex);
		
		// TODO ApplicationRuntimeExceptionでの判定
		
		return super.execute(ex, ae, mapping, formInstance, request, response);
	}
}
