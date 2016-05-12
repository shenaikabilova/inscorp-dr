/**
 * 
 */
package servlet;

import java.io.IOException;
import java.util.Date;

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
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
public class InsurerAddNewKasko extends HttpServlet {
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
		
//		String insurerId = request.getParameter("userName");
//		String insKaskoId = request.getParameter("insurenceID");
//		String insurenceFirstName = request.getParameter("insuredFirstName");
//		String insurenceSecondName = request.getParameter("insuredSecondName");
//		String insurenceFamily = request.getParameter("insuredLastName");
//		String insurenceEGN = request.getParameter("EGN");
//		String insurenceMobilePhone = request.getParameter("mobilePhone");
//		String insurenceAddress = request.getParameter("address");
//		int insurencePK = Integer.parseInt(request.getParameter("pKod"));
//		String vehicleRegistrationNumber = request.getParameter("registrationNumber");
//		String vehicleType = request.getParameter("vehicleType");
//		String vehicleRama = request.getParameter("ramaN");
//		String vehicleBranch = request.getParameter("vehicleBrand");
//		String vehicleModel = request.getParameter("vehicleModel");
//		String vehicleColor = request.getParameter("vehicleColor");
//		int vehicleYear = Integer.parseInt(request.getParameter("year"));
//		Date vehicleFirstRegistration =  request.getParameter("vehicleFirstReg");
//		
//		float vehicleEngine = Float.parseFloat(request.getParameter("vehicleEngine"));
//		int vehiclePlaceNumber = Integer.parseInt(request.getParameter("vehiclePlaces"));
//		float vehicleInsurenceValue = Float.parseFloat(request.getParameter("vehicleInsValue"));
//		float vehicleInsurencePremiq = Float.parseFloat(request.getParameter("vehicleInsPremiq"));
//		
//		KaskoDAO addKasko = new KaskoDAOImpl();
//		addKasko.insertKasko(new Kasko(insurerId, insKaskoId, insurenceFirstName, insurenceSecondName, 
//									   insurenceFamily, insurenceEGN, insurenceMobilePhone, insurenceAddress, 
//									   insurencePK, vehicleRegistrationNumber, vehicleType, vehicleRama, 
//									   vehicleBranch, vehicleModel, vehicleColor, vehicleYear, vehicleFirstRegistration, 
//									   vehicleEngine, vehiclePlaceNumber, vehicleInsurenceValue, vehicleInsurencePremiq));
	}
}