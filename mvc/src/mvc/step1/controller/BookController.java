package mvc.step1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.step1.action.Action;
import mvc.step1.action.ActionForward;

public class BookController extends HttpServlet implements Action {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("XXX.jsp"); // insert, update, delete
		RequestDispatcher view = req.getRequestDispatcher("XXX.jsp");
		req.setAttribute("bookList", new ArrayList<String>());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;
	}
	
	
}
