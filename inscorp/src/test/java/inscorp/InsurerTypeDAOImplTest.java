/**
 * 
 */
package inscorp;

import org.junit.Assert;
import org.junit.Test;

import dao_api.InsurerTypeDAO;
import dao_jdbc.InsurerTypeDAOImpl;

/**
 * @author shenaikabilova
 *
 */
public class InsurerTypeDAOImplTest {
	private static InsurerTypeDAO dao = new InsurerTypeDAOImpl();

	@Test
	public void listAll() {
		Assert.assertFalse(dao.listInsurerTypes().isEmpty());
//		
//		for(InsurerType i : dao.listInsurerTypes()) {
//			assertThat(dao.listInsurerTypes(), containsInAnyOrder(hasProperty("INSURENCE_TYPE", i.getInsurerType())));
//		}
	}
}