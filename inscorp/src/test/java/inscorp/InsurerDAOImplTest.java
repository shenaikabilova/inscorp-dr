/**
 * 
 */
package inscorp;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import Exceptions.InsCorpErrorException;
import dao_api.InsurerDAO;
import dao_jdbc.InsurerDAOImpl;
import model.Insurer;

/**
 * @author shenaikabilova
 *
 */
public class InsurerDAOImplTest {
	private static Insurer insurer = new Insurer("5", "�����", "��������", "shenaikabilova@abv.bg", "123456");
	private static InsurerDAO dao = new InsurerDAOImpl();

	@AfterClass
	static public void del() throws InsCorpErrorException {
		dao.delete(insurer.getInsurerId());
	}
	
	@Test
	public void testInsert() throws InsCorpErrorException {
		dao.insert(insurer);
		
		Assert.assertEquals(insurer.getInsurerId(), dao.searchUserName("5").getInsurerId());
		Assert.assertEquals(insurer.getInsurerName(), dao.searchUserName("5").getInsurerName()); 
		Assert.assertEquals(insurer.getInsurerFamily(), dao.searchUserName("5").getInsurerFamily());
		Assert.assertEquals(insurer.getInsurerEmail(), dao.searchUserName("5").getInsurerEmail());
		Assert.assertEquals(insurer.getInsurerPassword(), dao.searchUserName("5").getInsurerPassword());
	}
	
	@Test
	public void testUpdate() throws InsCorpErrorException {
		dao.update(insurer);
		
		Assert.assertEquals(insurer.getInsurerId(), dao.searchUserName("5").getInsurerId());
		Assert.assertEquals(insurer.getInsurerName(), dao.searchUserName("5").getInsurerName()); 
		Assert.assertEquals(insurer.getInsurerFamily(), dao.searchUserName("5").getInsurerFamily());
		Assert.assertEquals(insurer.getInsurerEmail(), dao.searchUserName("5").getInsurerEmail());
		Assert.assertEquals(insurer.getInsurerPassword(), dao.searchUserName("5").getInsurerPassword());
	}

	@Test 
	public void testDelete() throws InsCorpErrorException {
		dao.delete(insurer.getInsurerId());
		
		Assert.assertNull(dao.searchUserName("5").getInsurerId());
	}
	
	@Test
	public void testListAll() {
		Assert.assertFalse(dao.listInsurers().isEmpty());
	}
	
	@Test
	public void testSearchUserName() throws InsCorpErrorException {
		dao.insert(insurer);
		Assert.assertEquals(insurer.getInsurerId(), dao.searchUserName("5").getInsurerId());
		Assert.assertEquals(insurer.getInsurerName(), dao.searchUserName("5").getInsurerName()); 
		Assert.assertEquals(insurer.getInsurerFamily(), dao.searchUserName("5").getInsurerFamily());
		Assert.assertEquals(insurer.getInsurerEmail(), dao.searchUserName("5").getInsurerEmail());
		Assert.assertEquals(insurer.getInsurerPassword(), dao.searchUserName("5").getInsurerPassword());
	}
	
	@Test
	public void testIsUser() throws InsCorpErrorException {
		Assert.assertTrue(dao.isUser(insurer.getInsurerId(), insurer.getInsurerPassword()));
	}
}