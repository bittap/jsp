import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3 extends Test {
	@Override
	public void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("OK");
	}
}
