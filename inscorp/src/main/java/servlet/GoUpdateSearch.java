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

import model.GrajdanskaOtgovornost;
import dao_api.GrajdanskaOtgovornostDAO;
import dao_jdbc.GrajdanskaOtgovornostDAOImpl;

/**
 * Servlet for search existing insurance grajdanska otgovornost
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/searchGOUpdate")
public class GoUpdateSearch extends HttpServlet{
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
	 * Get method for searching existing insurance grajdanska otgovornost by specific ID
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String goID;
		
		if(!(goID = request.getParameter("searchGOByID")).isEmpty()) {
			GrajdanskaOtgovornostDAO searchByID = new GrajdanskaOtgovornostDAOImpl();
			
			List<GrajdanskaOtgovornost> result = new ArrayList<GrajdanskaOtgovornost>();
			result.add(searchByID.searchGO(goID));
			
			request.setAttribute("result", result);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/insurerGoUpdate.jsp");
			rd.forward(request, response);
		}
		else{
			String errmsg = "������ �� ����� �� ������ � ������!";
			request.setAttribute("errmsg", errmsg);
			RequestDispatcher view = request.getRequestDispatcher("InsurerErrors.jsp");
			view.forward(request,response);
		}
	}
}