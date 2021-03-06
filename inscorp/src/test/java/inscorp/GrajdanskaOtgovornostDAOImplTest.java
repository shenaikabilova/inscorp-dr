/**
 * 
 */
package inscorp;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao_api.GrajdanskaOtgovornostDAO;
import dao_jdbc.GrajdanskaOtgovornostDAOImpl;
import model.GrajdanskaOtgovornost;

/**
 * @author shenaikabilova
 *
 */
public class GrajdanskaOtgovornostDAOImplTest {
	@SuppressWarnings("deprecation")
	private static GrajdanskaOtgovornost go = new GrajdanskaOtgovornost("000001", "000001", "��������� ����", 
			"����", "������", "������", "8602020510", "��������", "��. �����", 9000, "111222", "�8887��", 
			"���� I� - �������, ����� � ������", "���������", "BG478965��78952�A", "����", "�5", 
			new Date(2016-1900, 7-1, 20), new Date(2017-1900, 7-1, 19), 12, 150, 150);
	private static GrajdanskaOtgovornostDAO dao = new GrajdanskaOtgovornostDAOImpl();
	
	@Before
	public void addBefore() {
		dao.insertGO(go);
	}
	
	@After
	public void delAfter() {
		dao.deleteGO(go.getInsurenceGrajdanskaOtgovornostID());
	}
	
	@AfterClass
	public static void delAfterClass() {
		dao.deleteGO(go.getInsurenceGrajdanskaOtgovornostID());
	}

	@Test
	public void testListAllGO() {
		Assert.assertFalse(dao.listGO().isEmpty());
	}
	
	@Test
	public void testInsertGO() {
		dao.insertGO(go);
		
		Assert.assertEquals(go.getInsurerID(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurerID());
		Assert.assertEquals(go.getInsurenceGrajdanskaOtgovornostID(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceGrajdanskaOtgovornostID());
		Assert.assertEquals(go.getInsurenceType(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceType());
		Assert.assertEquals(go.getInsurenceFirstName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceFirstName());
		Assert.assertEquals(go.getInsurenceSecondName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceSecondName());
		Assert.assertEquals(go.getInsurenceLastName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceLastName());
		Assert.assertEquals(go.getInsurenceEGN(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceEGN());
		Assert.assertEquals(go.getInsurenceCountry(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceCountry());
		Assert.assertEquals(go.getInsurenceAddress(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceAddress());
		Assert.assertEquals(go.getInsurencePK(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurencePK());
		Assert.assertEquals(go.getInsurenceMobilePhone(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceMobilePhone());
		Assert.assertEquals(go.getVehicleRegNumber(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleRegNumber());
		Assert.assertEquals(go.getZone(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getZone());
		Assert.assertEquals(go.getVehicleType(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleType());
		Assert.assertEquals(go.getVehicleRama(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleRama());
		Assert.assertEquals(go.getVehicleBrand(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleBrand());
		Assert.assertEquals(go.getVehicleModel(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleModel());
		Assert.assertEquals(go.getInsurenceDateFrom(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceDateFrom());
		Assert.assertEquals(go.getInsurenceDateTo(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceDateTo());
		Assert.assertEquals(go.getInsurenceMonths(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceMonths());
		Assert.assertEquals(go.getInsurenceValue(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceValue(), 0.001);
		Assert.assertEquals(go.getInsurencePremiq(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurencePremiq(), 0.001);
	}
	
	@Test
	public void testDeleteGO() {
		dao.deleteGO(go.getInsurenceGrajdanskaOtgovornostID());
		
		Assert.assertNull(dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceGrajdanskaOtgovornostID());
	}
	
	@Test
	public void testUpdateGO() {
		dao.updateGO(go);
		
		Assert.assertEquals(go.getInsurerID(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurerID());
		Assert.assertEquals(go.getInsurenceGrajdanskaOtgovornostID(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceGrajdanskaOtgovornostID());
		Assert.assertEquals(go.getInsurenceType(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceType());
		Assert.assertEquals(go.getInsurenceFirstName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceFirstName());
		Assert.assertEquals(go.getInsurenceSecondName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceSecondName());
		Assert.assertEquals(go.getInsurenceLastName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceLastName());
		Assert.assertEquals(go.getInsurenceEGN(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceEGN());
		Assert.assertEquals(go.getInsurenceCountry(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceCountry());
		Assert.assertEquals(go.getInsurenceAddress(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceAddress());
		Assert.assertEquals(go.getInsurencePK(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurencePK());
		Assert.assertEquals(go.getInsurenceMobilePhone(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceMobilePhone());
		Assert.assertEquals(go.getVehicleRegNumber(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleRegNumber());
		Assert.assertEquals(go.getZone(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getZone());
		Assert.assertEquals(go.getVehicleType(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleType());
		Assert.assertEquals(go.getVehicleRama(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleRama());
		Assert.assertEquals(go.getVehicleBrand(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleBrand());
		Assert.assertEquals(go.getVehicleModel(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleModel());
		Assert.assertEquals(go.getInsurenceDateFrom(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceDateFrom());
		Assert.assertEquals(go.getInsurenceDateTo(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceDateTo());
		Assert.assertEquals(go.getInsurenceMonths(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceMonths());
		Assert.assertEquals(go.getInsurenceValue(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceValue(), 0.001);
		Assert.assertEquals(go.getInsurencePremiq(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurencePremiq(), 0.001);
	
	}
	
	@Test
	public void testSearchGO() {
		Assert.assertEquals(go.getInsurerID(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurerID());
		Assert.assertEquals(go.getInsurenceGrajdanskaOtgovornostID(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceGrajdanskaOtgovornostID());
		Assert.assertEquals(go.getInsurenceType(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceType());
		Assert.assertEquals(go.getInsurenceFirstName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceFirstName());
		Assert.assertEquals(go.getInsurenceSecondName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceSecondName());
		Assert.assertEquals(go.getInsurenceLastName(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceLastName());
		Assert.assertEquals(go.getInsurenceEGN(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceEGN());
		Assert.assertEquals(go.getInsurenceCountry(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceCountry());
		Assert.assertEquals(go.getInsurenceAddress(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceAddress());
		Assert.assertEquals(go.getInsurencePK(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurencePK());
		Assert.assertEquals(go.getInsurenceMobilePhone(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceMobilePhone());
		Assert.assertEquals(go.getVehicleRegNumber(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleRegNumber());
		Assert.assertEquals(go.getZone(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getZone());
		Assert.assertEquals(go.getVehicleType(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleType());
		Assert.assertEquals(go.getVehicleRama(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleRama());
		Assert.assertEquals(go.getVehicleBrand(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleBrand());
		Assert.assertEquals(go.getVehicleModel(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getVehicleModel());
		Assert.assertEquals(go.getInsurenceDateFrom(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceDateFrom());
		Assert.assertEquals(go.getInsurenceDateTo(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceDateTo());
		Assert.assertEquals(go.getInsurenceMonths(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceMonths());
		Assert.assertEquals(go.getInsurenceValue(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurenceValue(), 0.001);
		Assert.assertEquals(go.getInsurencePremiq(), dao.searchGO(go.getInsurenceGrajdanskaOtgovornostID()).getInsurencePremiq(), 0.001);
	
	}
	
	@Test
	public void testSearchGOByInsurer() {
		Assert.assertFalse(dao.searchGOByInsurer(go.getInsurerID()).isEmpty());
	}
}