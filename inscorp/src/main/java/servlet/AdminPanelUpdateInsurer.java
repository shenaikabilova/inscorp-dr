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

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/updateInsurer")
public class AdminPanelUpdateInsurer extends HttpServlet {
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
	
		String insurerID = request.getParameter("insurerID");
		String insurerFirstName = request.getParameter("insurerName");
		String insurerLastName = request.getParameter("insurerFamily");
		String insurerEmail = request.getParameter("e-mail");
		String insurerPass1 = request.getParameter("password1");
		String insurerPass2 = request.getParameter("password2");
		
		
	}		
}