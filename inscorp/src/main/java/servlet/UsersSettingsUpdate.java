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

import model.Insurer;
import dao_api.InsurerDAO;
import dao_jdbc.InsurerDAOImpl;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/adminPanelSettings", "/insurerSettings"})
public class UsersSettingsUpdate extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	      super.init(config);
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         }
	      catch (Exception e) {
	         throw new UnavailableException(e.getMessage());
	      }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String userFamily = request.getParameter("userFamily");
		String userEmail = request.getParameter("userEmail");
		String pass1 = request.getParameter("password1");
		String pass2 = request.getParameter("password2");
		
		if(pass1.equals(pass2)) {
			InsurerDAO updateUserSettings = new InsurerDAOImpl();
			
			if(new InsurerDAOImpl().searchUserName(userID).getRole().equals("admin")){
				updateUserSettings.update(new Insurer(userID, userName, userFamily, userEmail, pass1, "admin"));
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminPanelSettings.jsp");
				dispatcher.forward(request,response);
			}
			else {
				updateUserSettings.update(new Insurer(userID, userName, userFamily, userEmail, pass1, "user"));
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insurerSettings.jsp");
				dispatcher.forward(request,response);
			}
		}
	}
}