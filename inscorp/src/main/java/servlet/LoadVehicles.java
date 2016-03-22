/**
 * 
 */
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao_jdbc.VehicleTypeDAOImpl;
import model.VehicleType;

/**
 * @author shenaikabilova
 *
 */

@SuppressWarnings("serial")
@WebServlet("/example")
public class LoadVehicles extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	      super.init(config);
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         }
	      catch (Exception e) {
	         throw new UnavailableException(e.getMessage());
	      }
	   }
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<VehicleType> listVehicleTypes = new VehicleTypeDAOImpl().listAllVehicleTypes();
		request.setAttribute("vehicleBrand", listVehicleTypes);
		request.getRequestDispatcher("/WEB-INF/example.jsp").forward(request, response);
	}
}