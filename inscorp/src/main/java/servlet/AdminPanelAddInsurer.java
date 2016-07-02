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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exceptions.InsCorpErrorException;
import model.Insurer;
import dao_api.InsurerDAO;
import dao_jdbc.InsurerDAOImpl;

/**
 * Servlet using for adding insurer from admin
 * @author shenaikabilova

 */
@SuppressWarnings("serial")
@WebServlet("/adminPanelAddInsurer")
public class AdminPanelAddInsurer extends HttpServlet {
	/** 
	 * servlet init method sets mysql driver for database connection
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
	 * Post method for adding insurer in database 
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String insurerID = request.getParameter("insurerID");
		String insurerFirstName = request.getParameter("insurerName");
		String insurerLastName = request.getParameter("insurerFamily");
		String insurerEmail = request.getParameter("e-mail");
		String insurerPass1 = request.getParameter("password1");
		String insurerPass2 = request.getParameter("password2");
		
		SendMail sendMail = new SendMail();
		
		MessageDigest m;
		BigInteger passEncrypt = null;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(insurerPass1.getBytes(), 0, insurerPass1.length());
			passEncrypt = new BigInteger(1,m.digest());
		    System.out.println(String.format("%1$032x", passEncrypt));  
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		if (insurerPass1.equals(insurerPass2)) {
			InsurerDAO addInsurer = new InsurerDAOImpl();
			try {
				addInsurer.insert(new Insurer(insurerID, insurerFirstName, insurerLastName, insurerEmail, String.format("%1$032x", passEncrypt)));
			} catch (InsCorpErrorException e) {
				request.setAttribute("errmsg", e.getMessage());
				RequestDispatcher view = request.getRequestDispatcher("AdminPanelErrors.jsp");
				view.forward(request,response);
				e.printStackTrace();
			}
			
			sendMail.sendMail(insurerID, insurerPass1, insurerEmail);
			response.sendRedirect("/inscorp/adminPanelAddInsurer.jsp");
		}
	}
}