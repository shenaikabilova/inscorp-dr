package model;

public class Insurer {
	public String insurerId;
	public String insurerName;
	public String insurerFamily;
	public String insurerPassword;
	
	public Insurer(String insurerId, String insurerName, String insurerFamily, String insurerPassword) {
		this.insurerId = insurerId;
		this.insurerName = insurerName;
		this.insurerFamily = insurerFamily;
		this.insurerPassword = insurerPassword;
	}

	public String getInsurerId() {
		return insurerId;
	}

	public void setInsurerId(String insurerId) {
		this.insurerId = insurerId;
	}

	public String getInsurerName() {
		return insurerName;
	}

	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}

	public String getInsurerFamily() {
		return insurerFamily;
	}

	public void setInsurerFamily(String insurerFamily) {
		this.insurerFamily = insurerFamily;
	}

	public String getInsurerPassword() {
		return insurerPassword;
	}

	public void setInsurerPassword(String insurerPassword) {
		this.insurerPassword = insurerPassword;
	}
	
}