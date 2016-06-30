/**
 * 
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exceptions.InsCorpErrorException;
import model.Insurer;
import dao_api.InsurerDAO;
import dao_jdbc.InsurerDAOImpl;

/**
 * Servlet for searching existing user by admin
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/updateUser")
public class AdminPanelSearchUser extends HttpServlet {
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
	 * Get method for searching existing user by admin
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user;
		InsurerDAO insurer = new InsurerDAOImpl();
		
		if (!(user = request.getParameter("username")).equals("")) {
			List<Insurer> result = new ArrayList<Insurer>();
			try {
				result.add(insurer.searchUserName(user));
			} catch (InsCorpErrorException e) {
				request.setAttribute("errmsg", e.toString());
				RequestDispatcher view = request.getRequestDispatcher("/AdminPanelErrors.jsp");
				view.forward(request,response);
				e.printStackTrace();
			}
			
			request.setAttribute("result", result);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminPanelViewUser.jsp");
			rd.forward(request, response);
		}
	}
}