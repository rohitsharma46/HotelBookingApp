package JspJdbcServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("pwd");
		
		
		DBClass dbc = new DBClass();
		Boolean valid = dbc.userAuth(userName,passWord);
		
		if(valid == true) {
			HttpSession session = request.getSession();
			session.setAttribute("user",userName);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else {
			System.out.println("sending to index.jsp");
			response.sendRedirect("index.jsp");
		}
	}

}
