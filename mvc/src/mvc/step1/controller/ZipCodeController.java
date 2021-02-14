package mvc.step1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import mvc.step1.action.Action;
import mvc.step1.action.ActionForward;
import mvc.step1.logic.ZipCodeLogic;

public class ZipCodeController extends HttpServlet implements Action {
	// execute �޼ҵ带 ȣ���ϰ� �ʹ�.
	Logger logger = Logger.getLogger(this.getClass().toString());
	ZipCodeLogic ZipCodeLogic = new ZipCodeLogic();
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("execute ȣ�� ����");
		String crud = req.getParameter("crud");
		System.out.println("crud="+crud);
		ActionForward af = new ActionForward();
		if("zipCodeList".equals(crud)) {
			logger.info("�����ȣ ��ȸ ȣ�� ����");
			
			String uDong = req.getParameter("dong");
			logger.info("����ڰ� �Է��� �� "+uDong);
			
			req.setAttribute("result", ZipCodeLogic.getZipCodeList(uDong));
			
			af.setRedirect(false);
			af.setPath("getZipCodeList.jsp");
		}
		return af;	
	}
}
