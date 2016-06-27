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
		
		SendMail sendMail = new SendMail();
		
		if (insurerPass1.equals(insurerPass2)) {
			InsurerDAO addInsurer = new InsurerDAOImpl();
			try {
				addInsurer.insert(new Insurer(insurerID, insurerFirstName, insurerLastName, insurerEmail, insurerPass1));
			} catch (InsCorpErrorException e) {
				request.setAttribute("errmsg", e.getMessage());
				RequestDispatcher view = request.getRequestDispatcher("AdminPanelErrors.jsp");
				view.forward(request,response);
				e.printStackTrace();
			}
			
			sendMail.sendMail(insurerID, insurerPass1, insurerEmail);
			
			response.sendRedirect("/inscorp/adminPanelAddInsurer.jsp");
		}
//		else {
//			String errmsg = "��������� ����������� �� ��������������� ����!";
//			request.setAttribute("errmsg", errmsg);
//			RequestDispatcher view = request.getRequestDispatcher("ErrorLogin.jsp");
//			view.forward(request,response);
//		}
	}
}