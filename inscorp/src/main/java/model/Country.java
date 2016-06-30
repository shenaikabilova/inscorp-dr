package model;

/**
 * The Country class represents country objects. 
 * @author shenaikabilova
 */
public class Country {
	private String country;
	
	public Country () {
		
	}

	public Country(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}