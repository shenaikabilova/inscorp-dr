/**
 * 
 */
package inscorp;

import org.junit.Assert;
import org.junit.Test;

import dao_api.VehicleBrandDAO;
import dao_jdbc.VehicleBrandDAOImpl;

/**
 * @author shenaikabilova
 *
 */
public class VehicleBrandDAOImplTest {
	private static VehicleBrandDAO dao = new VehicleBrandDAOImpl();
	
	@Test
	public void listAll() {
		Assert.assertFalse(dao.listAllVehicleBrand().isEmpty());
	}
}