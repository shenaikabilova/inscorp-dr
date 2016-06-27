package dao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InsCorpErrorException;
import dao_api.InsurerDAO;
import model.Insurer;

/**
 * @author shenaikabilova
 *
 */
public class InsurerDAOImpl implements InsurerDAO{
	@Override
	public List<Insurer> listInsurers() {
		List<Insurer> insurers;
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")){
			final String QUERY = "SELECT INSURER_ID, INSURER_NAME, INSURER_FAMILY, INSURER_EMAIL, INSURER_PASSWORD FROM insurers";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM insurers";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			PreparedStatement preparedStatementCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSet resultSetCount = preparedStatementCount.executeQuery();
			
			resultSetCount.next();
			int count = resultSetCount.getInt("count");
			
			insurers = new ArrayList<Insurer>(count);
			
			while(resultSet.next()) {
				String insurerID = resultSet.getString("INSURER_ID");
				String insurerName = resultSet.getString("INSURER_NAME");
				String insurerFamily = resultSet.getString("INSURER_FAMILY");
				String insurerEmail = resultSet.getString("INSURER_EMAIL");
				String insurerPassword = resultSet.getString("INSURER_PASSWORD");
				
				
				insurers.add(new Insurer(insurerID, insurerName, insurerFamily, insurerEmail, insurerPassword));
			}
			
			return insurers;
		} catch (Exception e) {
			return new ArrayList<Insurer>(0);
		}
	}

	@Override
	public void insert(Insurer insurer) throws InsCorpErrorException{
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "INSERT INTO insurers(INSURER_ID, INSURER_NAME, INSURER_FAMILY, INSURER_EMAIL, INSURER_PASSWORD) VALUES(?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.setString(1, insurer.getInsurerId());
			preparedStatement.setString(2, insurer.getInsurerName());
			preparedStatement.setString(3, insurer.getInsurerFamily());
			preparedStatement.setString(4, insurer.getInsurerEmail());
			preparedStatement.setString(5, insurer.getInsurerPassword());
			
			preparedStatement.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new InsCorpErrorException("Застраховател с това ID вече съществува!");
		} catch (SQLException e) {
			throw new InsCorpErrorException("Застрахователният агент не може да се добави!");
		}
	}

	@Override
	public void delete(String insurerID) throws InsCorpErrorException {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "DELETE FROM insurers WHERE INSURER_ID = '" + insurerID + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new InsCorpErrorException("Застрахователното лице не може да се изтрие!");
		}
	}

	@Override
	public void update(Insurer insurer) throws InsCorpErrorException {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")) {
			final String QUERY = "UPDATE insurers SET INSURER_ID=?, INSURER_NAME=?, INSURER_FAMILY=?, INSURER_EMAIL=?, INSURER_PASSWORD=? "
					+ "WHERE INSURER_ID = '" + insurer.getInsurerId() + "'";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			
			preparedStatement.setString(1, insurer.getInsurerId());
			preparedStatement.setString(2, insurer.getInsurerName());
			preparedStatement.setString(3, insurer.getInsurerFamily());
			preparedStatement.setString(4, insurer.getInsurerEmail());
			preparedStatement.setString(5, insurer.getInsurerPassword());
			
			preparedStatement.executeUpdate();
		}catch (SQLIntegrityConstraintViolationException e) {
			throw new InsCorpErrorException("Застрахователен агент с това ID вече съществува!");
		} catch (SQLException e) {
			throw new InsCorpErrorException("Застрахователният агент не може да се промени!");
		}
	}
	
	public Insurer searchUserName(String username) throws InsCorpErrorException {
		Insurer insurer = new Insurer();
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")){

			final String QUERY = "SELECT INSURER_ID, INSURER_NAME, INSURER_FAMILY, INSURER_EMAIL, INSURER_PASSWORD, role FROM insurers WHERE INSURER_ID = '" + username + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			ResultSet resultSet = pr.executeQuery();
			
			if(resultSet.next()) {
				String insurerID = resultSet.getString("INSURER_ID");
				String insurerName = resultSet.getString("INSURER_NAME");
				String insurerFamily = resultSet.getString("INSURER_FAMILY");
				String insurerEmail = resultSet.getString("INSURER_EMAIL");
				String insurerPassword = resultSet.getString("INSURER_PASSWORD");
				String role = resultSet.getString("role");
				
				insurer = new Insurer(insurerID, insurerName, insurerFamily, insurerEmail, insurerPassword, role);
				
				return insurer;
			}
			
		}catch (SQLException e) {
			throw new InsCorpErrorException("Застраховател с ID " + username + " не може да бъде открито!");
		}
		
		return insurer;
	}
	
	public boolean isUser (String username, String password) throws InsCorpErrorException {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")){

			final String QUERY = "SELECT INSURER_ID, INSURER_PASSWORD FROM insurers WHERE INSURER_ID = '" + username + "' and "
					+ "INSURER_PASSWORD = '" + password + "'";
			
			PreparedStatement pr = connection.prepareStatement(QUERY);
			ResultSet resultSet = pr.executeQuery();
			
			if(resultSet.next()) {
				return true;
			}
			
		}catch (SQLException e) {
			throw new InsCorpErrorException("Несъществуващ потребител!");
		}
		return false;
	}
}