/**
 * 
 */
package inscorp;

import org.junit.Assert;
import org.junit.Test;

import dao_api.VehicleTypeDAO;
import dao_jdbc.VehicleTypeDAOImpl;

/**
 * @author shenaikabilova
 *
 */
public class VehicleTypeDAOImplTest {
	private static VehicleTypeDAO dao = new VehicleTypeDAOImpl();
	
	@Test
	public void listAll() {
		Assert.assertFalse(dao.listVehicleTypes().isEmpty());
	}
}