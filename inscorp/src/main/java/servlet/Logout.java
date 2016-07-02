package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for logout 
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/logout")
public class Logout extends HttpServlet {
	/**
	 * Get method for logout
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		Cookie loginCookie = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("user")) {
					loginCookie = cookie;
					break;
				}
			}
		}
		if(loginCookie != null) {
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		response.sendRedirect("/inscorp/login.jsp");
	}
}