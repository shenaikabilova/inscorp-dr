/**
 * 
 */
package servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exceptions.InsCorpErrorException;
import dao_jdbc.InsurerDAOImpl;

/**
 * @author shenaikabilova
 *
 */
@WebServlet("/log")
public class log extends HttpServlet {
	/**
	 * Servlet init method sets mysql driver for database connection
	 * @throws ServletException
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	      super.init(config);
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         }
	      catch (Exception e) {
	         throw new UnavailableException(e.getMessage());
	      }
	}
	
	/**
	 * Post method for searching user in database
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
	
		MessageDigest m;
		BigInteger passEncrypt = null;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes(), 0, password.length());
			passEncrypt = new BigInteger(1,m.digest());
		    System.out.println(String.format("%1$032x", passEncrypt));  
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} 
		
		try {
			if(new InsurerDAOImpl().isUser(username, String.format("%1$032x", passEncrypt))) {
				try {
					if(new InsurerDAOImpl().searchUserName(username).getRole().equals("admin")) {
						Cookie loginCookie = new Cookie("user", username);
						loginCookie.setMaxAge(60*60*24); 
					    response.addCookie(loginCookie);
						response.sendRedirect("adminPanel.jsp");
					}
				} catch (InsCorpErrorException e) {
					request.setAttribute("errmsg", e);
					RequestDispatcher view = request.getRequestDispatcher("ErrorLogin.jsp");
					view.forward(request,response);
				}
				try {
					if(new InsurerDAOImpl().searchUserName(username).getRole().equals("user")) {
						String errmsg = "Грешно потребителско име или парола!";
						request.setAttribute("errmsg", errmsg);
						RequestDispatcher view = request.getRequestDispatcher("ErrorLogin.jsp");
						view.forward(request,response);
					}
				} catch (InsCorpErrorException e) {
					request.setAttribute("errmsg", e.getMessage());
					RequestDispatcher view = request.getRequestDispatcher("ErrorLogin.jsp");
					view.forward(request,response);
				}
			}
			else{ 
				String errmsg = "Грешно потребителско име или парола!";
				request.setAttribute("errmsg", errmsg);
				RequestDispatcher view = request.getRequestDispatcher("ErrorLogin.jsp");
				view.forward(request,response);
	        }
		} catch (InsCorpErrorException e) {
			request.setAttribute("errmsg", e.getMessage());
			RequestDispatcher view = request.getRequestDispatcher("ErrorLogin.jsp");
			view.forward(request,response);
		} 
	}
}