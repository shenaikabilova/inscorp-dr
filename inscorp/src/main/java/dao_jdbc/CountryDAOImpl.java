package dao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Country;
import dao_api.CountryDAO;

/**
 * This class implements CountryDAO interface
 * @author shenaikabilova
 */
public class CountryDAOImpl implements CountryDAO{

	/** List all countries from database
	 * @return list of countries
	 * @see dao_api.CountryDAO#listCountries()
	 */
	@Override
	public List<Country> listCountries() {
		List<Country> countries;
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")){
			final String QUERY = "SELECT COUNTRY FROM country;";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM country";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			PreparedStatement preparedStetmentCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSet resultSetCount = preparedStetmentCount.executeQuery();
			
			resultSetCount.next();
			int count = resultSetCount.getInt("count");
			
			countries = new ArrayList<Country>(count);
			
			while(resultSet.next()) {
				String country = resultSet.getString("COUNTRY");
				
				countries.add(new Country(country));
			}
			
			return countries;
		} catch (Exception e) {
			return new ArrayList<Country>(0);
		}
	}
}