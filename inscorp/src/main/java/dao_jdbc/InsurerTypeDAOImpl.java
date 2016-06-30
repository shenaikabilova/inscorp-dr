package dao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.InsurerType;
import dao_api.InsurerTypeDAO;

/**
 * This class implements InsurerTypeDAO interface
 * @author shenaikabilova
 */
public class InsurerTypeDAOImpl implements InsurerTypeDAO {

	/** List all insurer types in databse
	 * @return list insurers or null if list is empty
	 * @see dao_api.InsurerTypeDAO#listInsurerTypes()
	 */
	@Override
	public List<InsurerType> listInsurerTypes() {
		List<InsurerType> insurerTypes;
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")){
			final String QUERY = "SELECT INSURER_TYPE FROM insurer_types;";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM insurer_types";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			PreparedStatement preparedStetmentCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSet resultSetCount = preparedStetmentCount.executeQuery();
			
			resultSetCount.next();
			int count = resultSetCount.getInt("count");
			
			insurerTypes = new ArrayList<InsurerType>(count);
			
			while(resultSet.next()) {
				String insurerType = resultSet.getString("INSURER_TYPE");
				
				insurerTypes.add(new InsurerType(insurerType));
			}
			
			return insurerTypes;
		} catch (Exception e) {
			return new ArrayList<InsurerType>(0);
		}
	}

}