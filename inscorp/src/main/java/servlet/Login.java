package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_jdbc.InsurerDAOImpl;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	      super.init(config);
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         }
	      catch (Exception e) {
	         throw new UnavailableException(e.getMessage());
	      }
	   }
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(new InsurerDAOImpl().searchUserName(username).getInsurerId().equals(username) &&
		   new InsurerDAOImpl().searchUserName(username).getInsurerPassword().equals(password)) {
			
			if(new InsurerDAOImpl().searchUserName(username).getRole().equals("admin")) {
				Cookie loginCookie = new Cookie("user", username);
				loginCookie.setMaxAge(60*60*24); 
	            response.addCookie(loginCookie);
				response.sendRedirect("adminPanel.jsp");
			}
			if(new InsurerDAOImpl().searchUserName(username).getRole().equals("user")) {
				Cookie loginCookie = new Cookie("user", username);
				loginCookie.setMaxAge(60*60*24); 
	            response.addCookie(loginCookie);
	            response.sendRedirect("insurer.jsp");
			}
		} else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
	}
}