package front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceController {
	abstract void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}

