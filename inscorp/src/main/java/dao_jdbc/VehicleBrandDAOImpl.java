/**
 * 
 */
package dao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao_api.VehicleBrandDAO;
import model.VehicleBrand;

/**
 * This class implements VehicleBrandDAO interface
 * @author shenaikabilova
 *
 */
public class VehicleBrandDAOImpl implements VehicleBrandDAO {

	/** List all existing vehicle types in database
	 * @return list vehicle types or null if list is empty
	 * @see dao.TypeVehicleDAO#listAllVehicleTypes()
	 */
	@Override
	public List<VehicleBrand> listAllVehicleBrand() {
		List<VehicleBrand> vehicleBrands;
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurence", "root", "123456")){
			final String QUERY = "SELECT VEHICLE_BRANDS FROM vehicle_brands;";
			final String QUERY_COUNT = "SELECT COUNT(*) as count FROM vehicle_brands";
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			PreparedStatement preparedStetmentCount = connection.prepareStatement(QUERY_COUNT);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSet resultSetCount = preparedStetmentCount.executeQuery();
			
			resultSetCount.next();
			int count = resultSetCount.getInt("count");
			
			vehicleBrands = new ArrayList<VehicleBrand>(count);
			
			while(resultSet.next()) {
				String vehicleBrand = resultSet.getString("VEHICLE_BRANDS");
				
				vehicleBrands.add(new VehicleBrand(vehicleBrand));
			}
			
			return vehicleBrands;
		} catch (Exception e) {
			return new ArrayList<VehicleBrand>(0);
		}
	}
}