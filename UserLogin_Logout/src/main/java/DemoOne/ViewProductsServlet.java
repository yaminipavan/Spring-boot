package DemoOne;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		Cookie c[] = req.getCookies();// Getting the Cookies
		if (c == null) {
			pw.println("Session Expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		} else {
			String fName = c[0].getValue();
			pw.println("page of " + fName + "<br>");
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
			ArrayList<ProductBean> al = new RetrieveDAO().retrieve();
			if (al.size() == 0) {
				pw.println("<br>Products Not Available...<br>");
			} else {
				Iterator<ProductBean> it = al.iterator();
				while (it.hasNext()) {
					ProductBean pb = (ProductBean) it.next();
					pw.println("<br>" + pb.getCode() + "&nbsp&nbsp" + pb.getName() + "&nbsp&nbsp" + pb.getPrice()
							+ "&nbsp&nbsp" + pb.getQty() + "<br>");
				} // end of loop
			} // end of else
		}
	}
}
