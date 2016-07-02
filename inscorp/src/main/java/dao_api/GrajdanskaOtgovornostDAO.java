package dao_api;

import java.util.List;

import model.GrajdanskaOtgovornost;

/**
 * GrajdanskaOtgovnostDAO interface 
 * @author shenaikabilova
 */
public interface GrajdanskaOtgovornostDAO {
	public List<GrajdanskaOtgovornost> listGO();
	public void insertGO (GrajdanskaOtgovornost grajdanskaOtgovornost);
	public void deleteGO (String grajdanskaOtgovornostID);
	public void updateGO (GrajdanskaOtgovornost grajdanskaOtgovornost);
	public GrajdanskaOtgovornost searchGO (String grajdanskaOtgovornostID);
	public List<GrajdanskaOtgovornost> searchGOByInsurer (String userName);
	public String getLastInsID ();
}