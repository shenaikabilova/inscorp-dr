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
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/updateUser")
public class AdminPanelSearchUser extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	      super.init(config);
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         }
	      catch (Exception e) {
	         throw new UnavailableException(e.getMessage());
	      }
	}
	
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