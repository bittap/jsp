package mvc.step1.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import mvc.step1.action.Action;
import mvc.step1.action.ActionForward;
import mvc.step1.controller.ZipCodeController;

public class FrontMVC extends HttpServlet {
	Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	private void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("debug");
		logger.info("info");
		ActionForward af = null;
		
		Action action = new ZipCodeController();
		af = action.execute(req, resp);
		
		if(af != null)
		{
			if(af.isRedirect()) // sendRedirect√≥∏Æ 
			{
				resp.sendRedirect(af.getPath());
			}
			else // forward
			{
				System.out.println(af.getPath());
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req, resp);
			}
		}
	}
}
