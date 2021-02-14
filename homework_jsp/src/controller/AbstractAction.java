package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbstractAction implements Action {
	@Override
	public ActionForward actionFerformd(HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	
	protected String getExtensionExceptPath(HttpServletRequest req) {
		//getServletPath는 Context Path가 붙지 않으므로 나중에 서버 붙일 때 더 괜찮을꺼라고 생각했다.
		// /zipcode/*.do
		String requsetGetPath = req.getServletPath();
		
		String[] dividePath = requsetGetPath.split("/");
		if(dividePath.length != 3) new Exception("배열 사이즈가 맞지 않음");
		
		//*.do
		String lastPathName = dividePath[2];
		String[] lastPathNames = lastPathName.split("\\.");

		if(lastPathNames.length != 2) new Exception("lastPathName 사이즈가 맞지 않음");
		
		return lastPathNames[0];
	}
}
