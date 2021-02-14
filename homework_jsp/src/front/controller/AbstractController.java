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
		//getServletPath�� Context Path�� ���� �����Ƿ� ���߿� ���� ���� �� �� ����������� �����ߴ�.
		// /zipcode/*.do
		String requsetGetPath = req.getServletPath();
		
		String[] dividePath = requsetGetPath.split("/");
		if(dividePath.length != 3) new Exception("�迭 ����� ���� ����");
		
		String rootPath = dividePath[1];
		return rootPath;
	}
}
