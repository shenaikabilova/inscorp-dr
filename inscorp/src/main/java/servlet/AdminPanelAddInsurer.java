/**
 * 
 */
package servlet;

import java.io.IOException;

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
@WebServlet("/adminPanelAddInsurer")
public class AdminPanelAddInsurer extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		
		String insurerID = request.getParameter("insurerID");
		String insurerFirstName = request.getParameter("insurerName");
		String insurerLastName = request.getParameter("insurerFamily");
		String insurerEmail = request.getParameter("e-mail");
		String insurerPass1 = request.getParameter("password1");
		String insurerPass2 = request.getParameter("password2");
		
		if (insurerPass1.equals(insurerPass2)) {
			InsurerDAO addInsurer = new InsurerDAOImpl();
			addInsurer.insert(new Insurer(insurerID, insurerFirstName, insurerLastName, insurerEmail, insurerPass1));
			
			response.sendRedirect("/inscorp/adminPanelAddInsurer.jsp");
		}
		else {
			
		}
	}
}