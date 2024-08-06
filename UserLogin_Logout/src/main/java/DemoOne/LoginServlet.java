package DemoOne;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new LoginDAO().login(req);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if (ub == null) {
			pw.println("Invalid Login Process....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		} else {
			Cookie ck = new Cookie("fName", ub.getfName());
			// Creating Cookie
			res.addCookie(ck);// Adding Cookie to response
			pw.println("Welcome User " + ub.getfName() + "<br>");
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}
}
