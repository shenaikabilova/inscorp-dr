package dao_api;

import java.util.List;

import model.Kasko;

/**
 * @author shenaikabilova
 *
 */
public interface KaskoDAO {
	public List<Kasko> listKasko();
	public void insertKasko (Kasko kasko);
	public void deleteKasko (String kaskoID);
	public void updateKasko (Kasko kasko);
	public Kasko searchKasko (String kaskoID);
}