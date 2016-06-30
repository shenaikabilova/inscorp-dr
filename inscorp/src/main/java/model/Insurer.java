package model;

/**
 * The Insurer class represent insurer objects.
 * @author shenaikabilova
 */
public class Insurer {
	private String insurerId;
	private String insurerName;
	private String insurerFamily;
	private String insurerEmail;
	private String insurerPassword;
	private String role;
	
	public Insurer () {
		
	}
	
	public Insurer(String insurerId, String insurerName, String insurerFamily, String insurerEmail, String insurerPassword) {
		this.insurerId = insurerId;
		this.insurerName = insurerName;
		this.insurerFamily = insurerFamily;
		this.insurerEmail = insurerEmail;
		this.insurerPassword = insurerPassword;
	}
	
	public Insurer(String insurerId, String insurerName, String insurerFamily, String insurerEmail, String insurerPassword, String role) {
		this.insurerId = insurerId;
		this.insurerName = insurerName;
		this.insurerFamily = insurerFamily;
		this.insurerEmail = insurerEmail;
		this.insurerPassword = insurerPassword;
		this.role = role;
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
	
	public String getInsurerEmail() {
		return insurerEmail;
	}

	public void setInsurerEmail(String insurerEmail) {
		this.insurerEmail = insurerEmail;
	}

	public String getInsurerPassword() {
		return insurerPassword;
	}

	public void setInsurerPassword(String insurerPassword) {
		this.insurerPassword = insurerPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}