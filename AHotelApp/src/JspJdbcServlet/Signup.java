package JspJdbcServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/SignUp")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String nUser = request.getParameter("nUser");
		String lUser = request.getParameter("lUser");
		String age = request.getParameter("age");
		String nPwd = request.getParameter("nPwd");
		
		DBClass dbc  = new DBClass();
		
		boolean avail = dbc.checkExisting(nUser);
		if(avail) {
			System.out.println("Go Ahead");
			dbc.CreateUser(nUser,nPwd,age,lUser);
		}
		else {
			System.out.println("Recommend User another Username");
			System.out.println("sending to index.jsp");
			
			String msg = "User Already Exist, Please try with different User name";
			request.setAttribute("message",msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
