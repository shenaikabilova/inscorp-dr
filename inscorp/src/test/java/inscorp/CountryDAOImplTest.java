/**
 * 
 */
package inscorp;

import org.junit.Assert;
import org.junit.Test;

import dao_api.CountryDAO;
import dao_jdbc.CountryDAOImpl;

/**
 * @author shenaikabilova
 *
 */
public class CountryDAOImplTest {
	private static CountryDAO dao = new CountryDAOImpl();
	
	@Test 
	public void listAll() {
		Assert.assertFalse(dao.listCountries().isEmpty());
	}
}