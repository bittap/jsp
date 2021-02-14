package front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController extends HttpServlet implements InterfaceController {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	@Override
	public abstract void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected String getRootPath(HttpServletRequest req) {
		//getServletPath는 Context Path가 붙지 않으므로 나중에 서버 붙일 때 더 괜찮을꺼라고 생각했다.
		// /zipcode/*.do
		String requsetGetPath = req.getServletPath();
		
		String[] dividePath = requsetGetPath.split("/");
		if(dividePath.length != 3) new Exception("배열 사이즈가 맞지 않음");
		
		String rootPath = dividePath[1];
		return rootPath;
	}
}
