/**
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exceptions.InsCorpErrorException;
import dao_api.InsurerDAO;
import dao_jdbc.InsurerDAOImpl;

/**
 * Servlet for deleting existing insurer by admin
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/deleteUser")
public class AdminPanelDeleteUser extends HttpServlet {
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
	 * Post method for deleting insurer by admin
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID;
		
		if(!(userID = request.getParameter("userID")).isEmpty()) {
			InsurerDAO insurer = new InsurerDAOImpl();
			try {
				if(!(insurer.searchUserName(userID).getInsurerId() == null)) {
					insurer.delete(userID);
					response.sendRedirect("/inscorp/adminPanelInsurers.jsp");
				}
				else {
					String errmsg = "����������� �� ��������������� ���� - ���������!";
					request.setAttribute("errmsg", errmsg);
					RequestDispatcher view = request.getRequestDispatcher("AdminPanelErrors.jsp");
					view.forward(request,response);
				}
			} catch (InsCorpErrorException e) {
				request.setAttribute("errmsg", e.getMessage());
				RequestDispatcher view = request.getRequestDispatcher("AdminPanelErrors.jsp");
				view.forward(request,response);
			}
		}
	}
}