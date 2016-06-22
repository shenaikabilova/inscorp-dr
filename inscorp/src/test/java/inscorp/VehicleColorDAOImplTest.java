/**
 * 
 */
package inscorp;

import org.junit.Assert;
import org.junit.Test;

import dao_api.VehicleColorDAO;
import dao_jdbc.VehicleColorDAOImpl;

/**
 * @author shenaikabilova
 *
 */
public class VehicleColorDAOImplTest {
	private static VehicleColorDAO dao = new VehicleColorDAOImpl();
	
	@Test
	public void listAll() {
		Assert.assertFalse(dao.listAllVehicleColors().isEmpty());
	}
}