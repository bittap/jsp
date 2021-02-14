package login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import common.vo.BoardVO;
import controller.AbstractAction;
import controller.ActionForward;
import login.logic.LoginLogic;
import login.vo.LoginVO;
import zipcode.logic.ZipcodeLogic;

public class LoginController extends AbstractAction {
	Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Override
	public ActionForward actionFerformd(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("loginController 시작");
		ActionForward actionForward = new ActionForward();
		
		// list.do 일경우 => list
		String path = getExtensionExceptPath(req);
		
		logger.info("path = "+path);

		HttpSession session = req.getSession();
		

		switch (path) {
		case "login":
			actionForward.setPath("login");
			actionForward.setRedirect(true);
			break;
		case "loginAction":
			actionForward.setPath("login_action");
			actionForward.setRedirect(false);
			
			LoginVO loginVO = new LoginVO();
			loginVO.setId((String)req.getParameter("id"));
			loginVO.setPassword((String)req.getParameter("password"));
			//System.out.println("(String)req.getParameter(\"id\") = "+(String)req.getParameter("id"));
			//System.out.println("(String)req.getParameter(\"password\") = "+(String)req.getParameter("password"));
			LoginLogic loginLogic = new LoginLogic(loginVO);
			String result = loginLogic.login();
			System.out.println("result = "+result);
			if(result == "03")
			{
				session.setAttribute("id", (String)req.getParameter("id"));
				session.setAttribute("password", (String)req.getParameter("password"));
			}
			req.setAttribute("result", result);
			break;
		case "logout":
			actionForward.setPath("logout_action");
			actionForward.setRedirect(true);
			session.removeAttribute("id");
			session.removeAttribute("password");
			break;

		default:
			break;
		}
		return actionForward;
	}
}
