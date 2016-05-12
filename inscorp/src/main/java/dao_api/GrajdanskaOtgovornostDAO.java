/**
 * 
 */
package dao_api;

import java.util.List;

import model.GrajdanskaOtgovornost;

/**
 * @author shenaikabilova
 *
 */
public interface GrajdanskaOtgovornostDAO {
	public List<GrajdanskaOtgovornost> listGO();
	public void insertGO (GrajdanskaOtgovornost grajdanskaOtgovornost);
	public void deleteGO (GrajdanskaOtgovornost grajdanskaOtgovornostID);
	public void updateGO (GrajdanskaOtgovornost grajdanskaOtgovornost);
	public GrajdanskaOtgovornost searchGO (GrajdanskaOtgovornost grajdanskaOtgovornostID);
}