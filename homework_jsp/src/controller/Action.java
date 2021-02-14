package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	abstract ActionForward actionFerformd(HttpServletRequest req, HttpServletResponse resp);
}
