package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbstractAction implements Action {
	@Override
	public ActionForward actionFerformd(HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	
	protected String getExtensionExceptPath(HttpServletRequest req) {
		//getServletPath�� Context Path�� ���� �����Ƿ� ���߿� ���� ���� �� �� ����������� �����ߴ�.
		// /zipcode/*.do
		String requsetGetPath = req.getServletPath();
		
		String[] dividePath = requsetGetPath.split("/");
		if(dividePath.length != 3) new Exception("�迭 ����� ���� ����");
		
		//*.do
		String lastPathName = dividePath[2];
		String[] lastPathNames = lastPathName.split("\\.");

		if(lastPathNames.length != 2) new Exception("lastPathName ����� ���� ����");
		
		return lastPathNames[0];
	}
}
