/**
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import bussines_logic.KaskoPremiq;

/**
 * @author shenaikabilova
 *
 */
@WebServlet("/value")
public class KaskoPremiqServlet extends HttpServlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		double value = Double.parseDouble(request.getParameter("vehicleInsValue"));
		
		KaskoPremiq premiq = new KaskoPremiq();
		request.setAttribute("vehicleInsPremiq", premiq.valueSum(value));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("insurerAddNewKasko.jsp");
		dispatcher.forward(request,response);
	}
}