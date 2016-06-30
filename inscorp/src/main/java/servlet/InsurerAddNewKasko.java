/**
 * 
 */
package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet for inserting new insurance kasko
 * @author shenaikabilova
 *
 */
@SuppressWarnings("serial")
@WebServlet("/addNewKasko")
public class InsurerAddNewKasko extends HttpServlet {
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
	 * Post method for inserting new kasko
	 * @param request get or set parameters from jsp
	 * @param response redirect to jsp
	 * @throws ServletException, IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String insurerId = request.getParameter("userName");
		String insKaskoId = request.getParameter("insurenceID");
		String insType = request.getParameter("insType");
		String insurenceFirstName = request.getParameter("insuredFirstName");
		String insurenceSecondName = request.getParameter("insuredSecondName");
		String insurenceFamily = request.getParameter("insuredLastName");
		String insurenceEGN = request.getParameter("EGN");
		String insurenceMobilePhone = request.getParameter("mobilePhone");
		String insurenceAddress = request.getParameter("address");
		int insurencePK = Integer.parseInt(request.getParameter("pKod"));
		String vehicleRegistrationNumber = request.getParameter("registrationNumber");
		String vehicleType = request.getParameter("vehicleType");
		String vehicleRama = request.getParameter("ramaN");
		String vehicleBrand = request.getParameter("vehicleBrand");
		String vehicleModel = request.getParameter("vehicleModel");
		String vehicleColor = request.getParameter("vehicleColor");
		int vehicleYear = Integer.parseInt(request.getParameter("year"));
		
		String vehicleFirstRegistration =  request.getParameter("vehicleFirstReg");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		try {
			startDate = sdf.parse(vehicleFirstRegistration);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		float vehicleEngine = Float.parseFloat(request.getParameter("vehicleEngine"));
		int vehiclePlaceNumber = Integer.parseInt(request.getParameter("vehiclePlaces"));
		float vehicleInsurenceValue = Float.parseFloat(request.getParameter("vehicleInsValue"));
		float vehicleInsurencePremiq = Float.parseFloat(request.getParameter("vehicleInsPremiq"));
		
		KaskoDAO addKasko = new KaskoDAOImpl();
		addKasko.insertKasko(new Kasko(insurerId, insKaskoId, insType, insurenceFirstName, insurenceSecondName, 
									   insurenceFamily, insurenceEGN, insurenceMobilePhone, insurenceAddress, 
									   insurencePK, vehicleRegistrationNumber, vehicleType, vehicleRama, 
									   vehicleBrand, vehicleModel, vehicleColor, vehicleYear, startDate, 
									   vehicleEngine, vehiclePlaceNumber, vehicleInsurenceValue, vehicleInsurencePremiq));
	
		String errmsg = "������� ��������!";
		request.setAttribute("errmsg", errmsg);
		RequestDispatcher view = request.getRequestDispatcher("InsurerErrors.jsp");
		view.forward(request,response);
	}
}