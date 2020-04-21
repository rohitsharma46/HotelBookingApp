package JspJdbcServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String uName = (String) session.getAttribute("user");
		
		String pwd =request.getParameter("nPwd");
		DBClass dbc = new DBClass();
		
		try {
			if(session!=null&&uName!=null) {
				System.out.println("updating password for "+uName);
				dbc.updatePwd(uName,pwd);	
				response.sendRedirect("Home.jsp");
			}
			else {
				response.sendRedirect("insex.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Password can't be updated");
			e.printStackTrace();
		}
	}

}
