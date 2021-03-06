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

import model.Kasko;
import dao_api.KaskoDAO;
import dao_jdbc.KaskoDAOImpl;

/** 
 * Servlet for searching insurance kasko with specified ID
 * @author shenaikabilova
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/searchKaskoByID")
public class SearchKaskoByID extends HttpServlet {
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
	 * Get method for searching kasko by specific ID
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String kaskoID;
		
		if(!(kaskoID = request.getParameter("searchKaskoByID")).isEmpty()) {
			KaskoDAO searchByID = new KaskoDAOImpl();
			
			if(searchByID.searchKasko(kaskoID).getInsKaskoId() != null) {
				List<Kasko> result = new ArrayList<Kasko>();
				result.add(searchByID.searchKasko(kaskoID));
				
				if(!(result.isEmpty())) {
				
					request.setAttribute("result", result);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/searchKaskoResults.jsp");
					rd.forward(request, response);
				}
			}
			else {
				String errmsg = "�� � �������� ����������� '�����' � ���� �����!";
				request.setAttribute("errmsg", errmsg);
				RequestDispatcher view = request.getRequestDispatcher("InsurerErrors.jsp");
				view.forward(request,response);
			}
		}
		else {
			String errmsg = "������ �� ����� �� ������ � ������!";
			request.setAttribute("errmsg", errmsg);
			RequestDispatcher view = request.getRequestDispatcher("InsurerErrors.jsp");
			view.forward(request,response);
		}
	}
}