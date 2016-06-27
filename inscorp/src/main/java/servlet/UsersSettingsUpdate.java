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
		
		SendMail sendMail = new SendMail();
		
		if(pass1.equals(pass2)) {
			InsurerDAO updateUserSettings = new InsurerDAOImpl();
			
			try {
				if(new InsurerDAOImpl().searchUserName(userID).getRole().equals("admin")){
					try {
						updateUserSettings.update(new Insurer(userID, userName, userFamily, userEmail, pass1, "admin"));
					} catch (InsCorpErrorException e) {
						request.setAttribute("errmsg", e.toString());
						RequestDispatcher view = request.getRequestDispatcher("/AdminPanelErors.jsp");
						view.forward(request,response);
						e.printStackTrace();
					}
					
					sendMail.sendMail(userID, pass1, userEmail);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminPanelSettings.jsp");
					dispatcher.forward(request,response);
				}
			} catch (InsCorpErrorException e1) {
				request.setAttribute("errmsg", e1.toString());
				RequestDispatcher view = request.getRequestDispatcher("/AdminPanelErors.jsp");
				view.forward(request,response);
				e1.printStackTrace();
			}
			try {
				if(new InsurerDAOImpl().searchUserName(userID).getRole().equals("user")){
					try {
						updateUserSettings.update(new Insurer(userID, userName, userFamily, userEmail, pass1, "user"));
					} catch (InsCorpErrorException e) {
						request.setAttribute("errmsg", e.toString());
						RequestDispatcher view = request.getRequestDispatcher("/InsurerErrors.jsp");
						view.forward(request,response);
						e.printStackTrace();
					}
					
					sendMail.sendMail(userID, pass1, userEmail);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insurerSettings.jsp");
					dispatcher.forward(request,response);
				}
			} catch (InsCorpErrorException e) {
				request.setAttribute("errmsg", e.toString());
				RequestDispatcher view = request.getRequestDispatcher("/InsurerErrors.jsp");
				view.forward(request,response);
				e.printStackTrace();
			}
		}
	}
}