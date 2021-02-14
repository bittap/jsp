package front.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import controller.ActionForward;
import front.controller.AbstractController;
import login.controller.LoginController;
import sun.nio.ch.Net;
import zipcode.controller.ZipcodeController;

//http://localhost:8080/zipcode/list.do
public class FrontController extends AbstractController {
	
	Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Override
	public void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		logger.info("FrontController 접근");

		String rootPath = getRootPath(req);
		
		logger.info("rootPath  = "+rootPath);
		
		ActionForward actionForward = null;
		
		switch (rootPath) {
		case "zipcode":
			ZipcodeController zipcodeController = new ZipcodeController();
			actionForward = zipcodeController.actionFerformd(req, resp);
			break;
		case "login":
			LoginController loginController = new LoginController();
			actionForward = loginController.actionFerformd(req, resp);
			break;

		default:
			break;
		}
		
		logger.info("isRedirect 유무  = "+actionForward.isRedirect());
		logger.info("path  = "+actionForward.getPath());
		
		if(actionForward.isRedirect())
		{
			resp.sendRedirect(actionForward.getPath());
		}
		else
		{
			RequestDispatcher rs = req.getRequestDispatcher(actionForward.getPath());
			rs.forward(req, resp);
		}
	}
}
