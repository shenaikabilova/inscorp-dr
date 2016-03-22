package dao_jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao_api.KaskoDAO;
import model.Kasko;

/**
 * @author shenaikabilova
 *
 */
public class KaskoDAOImpl implements KaskoDAO{

	@Override
	public List<Kasko> listKasko() {
		List<Kasko> listKasko;
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "SELECT INSURENCE_ID, INSURENCE_FIRST_NAME, INSURENCE_SECOND_NAME,"
					+ "INSURENCE_FAMILY, INSURENCE_EGN, INSURENCE_MOBILE_PHONE, INSURENCE_ADDRESS, INSURENCE_PK, "
					+ "VEHICLE_REGISTRATION_NUMBER, VEHICLE_TYPE, VEHICLE_RAMA, VEHICLE_BRANCH, VEHICLE_MODEL,"
					+ "VEHICLE_COLOR, VEHICLE_YEAR, VEHICLE_FIRST_REGISTRATION, VEHICLE_ENGINE, VEHICLE_PLACE_NUMBER,"
					+ "VEHICLE_INSURANCE_VALUE, VEHICLE_INSURANCE_PREMIQ FROM kasko";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM kasko";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			PreparedStatement preparedStetmentCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSet resultSetCount = preparedStetmentCount.executeQuery();
			
			int count = resultSetCount.getInt("count");
			
			listKasko = new ArrayList<Kasko>(count);
			
			while(resultSet.next()) {
				String insKaskoId = resultSet.getString("INSURER_ID");
				String insurenceFirstName = resultSet.getString("INSURENCE_FIRST_NAME");
				String insurenceSecondName = resultSet.getString("INSURENCR_SECOND_NAME");
				String insurenceFamily = resultSet.getString("INSURECE_FAMILY");
				String insurenceEGN = resultSet.getString("INSURENCE_EGN");
				String insurenceMobilePhone = resultSet.getString("INSURENCE_MOBILE_PHONE");
				String insurenceAddress = resultSet.getString("INSURENCE_ADDRESS");
				int insurencePK = resultSet.getInt("INSURENCE_PK");
				String vehicleRegistrationNumber = resultSet.getString("VEHICLE_REGISTRATION_NUMBER");
				String vehicleType = resultSet.getString("VEHICLE_TYPE");
				String vehicleRama = resultSet.getString("VEHICLE_RAMA");
				String vehicleBranch = resultSet.getString("VEHICLE_BRANCH");
				String vehicleModel = resultSet.getString("VEHICLE_MODEL");
				String vehicleColor = resultSet.getString("VEHICLE_COLOR");
				int vehicleYear = resultSet.getInt("VEHICLE_YEAR");
				Date vehicleFirstRegistration = resultSet.getDate("VEHICLE_FIRST_REGISTRATION");
				float vehicleEngine = resultSet.getFloat("VEHICLE_ENGINE");
				int vehiclePlaceNumber = resultSet.getInt("VEHICLE_PLACE_NUMBER");
				float vehicleInsurenceValue = resultSet.getFloat("VEHICLE_INSURANCE_VALUE");
				float vehicleInsurencePremiq = resultSet.getFloat("VEHICLE_INSURANCE_PREMIQ");
				
				listKasko.add((new Kasko(insKaskoId, insurenceFirstName, insurenceSecondName, 
						insurenceFamily, insurenceEGN, insurenceMobilePhone, insurenceAddress, insurencePK, 
						vehicleRegistrationNumber, vehicleType, vehicleRama, vehicleBranch, vehicleModel, vehicleColor, 
						vehicleYear, vehicleFirstRegistration, vehicleEngine, vehiclePlaceNumber, vehicleInsurenceValue, 
						vehicleInsurencePremiq)));
			}
			return listKasko;
		} catch (Exception e) {
			return new ArrayList<Kasko>(0);
		}
	}

	@Override
	public void insertKasko(Kasko kasko) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "INSERT INTO kasko(INSURER_ID, INSURENCE_ID, INSURENCE_FIRST_NAME, INSURENCE_SECOND_NAME,"
					+ "INSURENCE_FAMILY, INSURENCE_EGN, INSURENCE_MOBILE_PHONE, INSURENCE_ADDRESS, INSURENCE_PK, "
					+ "VEHICLE_REGISTRATION_NUMBER, VEHICLE_TYPE, VEHICLE_RAMA, VEHICLE_BRANCH, VEHICLE_MODEL,"
					+ "VEHICLE_COLOR, VEHICLE_YEAR, VEHICLE_FIRST_REGISTRATION, VEHICLE_ENGINE, VEHICLE_PLACE_NUMBER,"
					+ "VEHICLE_INSURANCE_VALUE, VEHICLE_INSURANCE_PREMIQ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.setString(1, kasko.getInsurerId());
			preparedStatement.setString(1, kasko.getInsKaskoId());
			preparedStatement.setString(3, kasko.getInsurenceFirstName());
			preparedStatement.setString(4, kasko.getInsurenceSecondName());
			preparedStatement.setString(5, kasko.getInsurenceFamily());
			preparedStatement.setString(6, kasko.getInsurenceEGN());
			preparedStatement.setString(7, kasko.getInsurenceMobilePhone());
			preparedStatement.setString(8, kasko.getInsurenceAddress());
			preparedStatement.setInt(9, kasko.getInsurencePK());
			preparedStatement.setString(10, kasko.getVehicleRegistrationNumber());
			preparedStatement.setString(11, kasko.getVehicleType());
			preparedStatement.setString(12, kasko.getVehicleRama());
			preparedStatement.setString(13, kasko.getVehicleBranch());
			preparedStatement.setString(14, kasko.getVehicleModel());
			preparedStatement.setString(15, kasko.getVehicleColor());
			preparedStatement.setInt(16, kasko.getVehicleYear());
			preparedStatement.setDate(17, new Date(kasko.getVehicleFirstRegistration().getTime()));
			preparedStatement.setFloat(18, kasko.getVehicleEngine());
			preparedStatement.setInt(19, kasko.getVehiclePlaceNumber());
			preparedStatement.setFloat(20, kasko.getVehicleInsurenceValue());
			preparedStatement.setFloat(21, kasko.getVehicleInsurencePremiq());
			
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteKasko(String kaskoID) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "DELETE FROM kasko WHERE = '" + kaskoID + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateKasko(Kasko kasko) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "UPDATE kasko INSURER_ID=?, INSURENCE_ID=?, INSURENCE_FIRST_NAME=?, INSURENCE_SECOND_NAME=?,"
					+ "INSURENCE_FAMILY=?, INSURENCE_EGN=?, INSURENCE_MOBILE_PHONE=?, INSURENCE_ADDRESS=?, INSURENCE_PK=?, "
					+ "VEHICLE_REGISTRATION_NUMBER=?, VEHICLE_TYPE=?, VEHICLE_RAMA=?, VEHICLE_BRANCH=?, VEHICLE_MODEL=?,"
					+ "VEHICLE_COLOR, VEHICLE_YEAR, VEHICLE_FIRST_REGISTRATION, VEHICLE_ENGINE, VEHICLE_PLACE_NUMBER,"
					+ "VEHICLE_INSURANCE_VALUE=?, VEHICLE_INSURANCE_PREMIQ=? WHERE INSURENCE_ID = '" + kasko.getInsKaskoId() + "'";
		
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.setString(1, kasko.getInsurerId());
			preparedStatement.setString(1, kasko.getInsKaskoId());
			preparedStatement.setString(3, kasko.getInsurenceFirstName());
			preparedStatement.setString(4, kasko.getInsurenceSecondName());
			preparedStatement.setString(5, kasko.getInsurenceFamily());
			preparedStatement.setString(6, kasko.getInsurenceEGN());
			preparedStatement.setString(7, kasko.getInsurenceMobilePhone());
			preparedStatement.setString(8, kasko.getInsurenceAddress());
			preparedStatement.setInt(9, kasko.getInsurencePK());
			preparedStatement.setString(10, kasko.getVehicleRegistrationNumber());
			preparedStatement.setString(11, kasko.getVehicleType());
			preparedStatement.setString(12, kasko.getVehicleRama());
			preparedStatement.setString(13, kasko.getVehicleBranch());
			preparedStatement.setString(14, kasko.getVehicleModel());
			preparedStatement.setString(15, kasko.getVehicleColor());
			preparedStatement.setInt(16, kasko.getVehicleYear());
			preparedStatement.setDate(17, new Date(kasko.getVehicleFirstRegistration().getTime()));
			preparedStatement.setFloat(18, kasko.getVehicleEngine());
			preparedStatement.setInt(19, kasko.getVehiclePlaceNumber());
			preparedStatement.setFloat(20, kasko.getVehicleInsurenceValue());
			preparedStatement.setFloat(21, kasko.getVehicleInsurencePremiq());
			
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Kasko searchKasko(String kaskoID) {
		Kasko kasko = new Kasko();
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "SELECT INSURENCE_ID, INSURENCE_FIRST_NAME, INSURENCE_SECOND_NAME,"
					+ "INSURENCE_FAMILY, INSURENCE_EGN, INSURENCE_MOBILE_PHONE, INSURENCE_ADDRESS, INSURENCE_PK, "
					+ "VEHICLE_REGISTRATION_NUMBER, VEHICLE_TYPE, VEHICLE_RAMA, VEHICLE_BRANCH, VEHICLE_MODEL,"
					+ "VEHICLE_COLOR, VEHICLE_YEAR, VEHICLE_FIRST_REGISTRATION, VEHICLE_ENGINE, VEHICLE_PLACE_NUMBER,"
					+ "VEHICLE_INSURANCE_VALUE, VEHICLE_INSURANCE_PREMIQ FROM kasko WHERE INSURENCE_ID = '" + kaskoID + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String insKaskoId = resultSet.getString("INSURER_ID");
				String insurenceFirstName = resultSet.getString("INSURENCE_FIRST_NAME");
				String insurenceSecondName = resultSet.getString("INSURENCR_SECOND_NAME");
				String insurenceFamily = resultSet.getString("INSURECE_FAMILY");
				String insurenceEGN = resultSet.getString("INSURENCE_EGN");
				String insurenceMobilePhone = resultSet.getString("INSURENCE_MOBILE_PHONE");
				String insurenceAddress = resultSet.getString("INSURENCE_ADDRESS");
				int insurencePK = resultSet.getInt("INSURENCE_PK");
				String vehicleRegistrationNumber = resultSet.getString("VEHICLE_REGISTRATION_NUMBER");
				String vehicleType = resultSet.getString("VEHICLE_TYPE");
				String vehicleRama = resultSet.getString("VEHICLE_RAMA");
				String vehicleBranch = resultSet.getString("VEHICLE_BRANCH");
				String vehicleModel = resultSet.getString("VEHICLE_MODEL");
				String vehicleColor = resultSet.getString("VEHICLE_COLOR");
				int vehicleYear = resultSet.getInt("VEHICLE_YEAR");
				Date vehicleFirstRegistration = resultSet.getDate("VEHICLE_FIRST_REGISTRATION");
				float vehicleEngine = resultSet.getFloat("VEHICLE_ENGINE");
				int vehiclePlaceNumber = resultSet.getInt("VEHICLE_PLACE_NUMBER");
				float vehicleInsurenceValue = resultSet.getFloat("VEHICLE_INSURANCE_VALUE");
				float vehicleInsurencePremiq = resultSet.getFloat("VEHICLE_INSURANCE_PREMIQ");
				
				kasko = new Kasko(insKaskoId, insurenceFirstName, insurenceSecondName, insurenceFamily, insurenceEGN, 
						insurenceMobilePhone, insurenceAddress, insurencePK, vehicleRegistrationNumber, vehicleType, 
						vehicleRama, vehicleBranch, vehicleModel, vehicleColor, vehicleYear, vehicleFirstRegistration, 
						vehicleEngine, vehiclePlaceNumber, vehicleInsurenceValue, vehicleInsurencePremiq);
			}
					
			return kasko;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kasko;
	}

}