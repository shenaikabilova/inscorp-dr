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
import model.Kasko;
import dao_api.GrajdanskaOtgovornostDAO;
import dao_api.KaskoDAO;
import dao_jdbc.GrajdanskaOtgovornostDAOImpl;
import dao_jdbc.KaskoDAOImpl;

/**
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/searchGOByID")
public class SearchGOByID extends HttpServlet {
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

		String goID;
		
		if(!(goID = request.getParameter("searchByID")).isEmpty()) {
			GrajdanskaOtgovornostDAO searchByID = new GrajdanskaOtgovornostDAOImpl();
			
			List<GrajdanskaOtgovornost> result = new ArrayList<GrajdanskaOtgovornost>();
			result.add(searchByID.searchGO(goID));
			
			request.setAttribute("result", result);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/searchKaskoResults.jsp");
			rd.forward(request, response);
		}
	}
}