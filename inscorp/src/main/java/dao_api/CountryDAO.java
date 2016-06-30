package dao_api;

import java.util.List;

import model.Country;

/**
 * CountryDAO interface
 * @author shenaikabilova
 *
 */
public interface CountryDAO {
	public List<Country> listCountries();
}