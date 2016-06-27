package dao_api;

import java.util.List;

import Exceptions.InsCorpErrorException;
import model.Insurer;

/**
 * @author shenaikabilova
 *
 */
public interface InsurerDAO {
	public List<Insurer> listInsurers();
	public void insert(Insurer insurer) throws InsCorpErrorException;
	public void delete(String insurerID) throws InsCorpErrorException;
	public void update(Insurer insurer) throws InsCorpErrorException;
	public Insurer searchUserName (String username) throws InsCorpErrorException;
	public boolean isUser (String username, String password) throws InsCorpErrorException;
}