/**
 * 
 */
package model;

/**
 * @author shenaikabilova
 *
 */
public class GrajdanskaOtgovornost {
	private String insurerID;
	private String insurenceKaskoID;
	private String insurenceType;
	private String insurenceFirstName;
	private String insurenceSecondName;
	private String insurenceLastName;
	private String insurenceEGN;
	private String insurenceCountry;
	private String insurenceAddress;
	private String insurencePK;
	private String insurenceMobilePhone;
	private String vehicleRegNumber;
	private String vehicleType;
	private String vehicleRama;
	private String vehicleBranch;
	private String vehicleModel;
	private String insurenceDateFrom;
	private String insurenceDateTo;
	private int insurenceMonths;
	private float insurenceValue;
	private float insurencePremiq;
	
	public GrajdanskaOtgovornost () {}

	public GrajdanskaOtgovornost(String insurerID, String insurenceKaskoID, String insurenceType,
			String insurenceFirstName, String insurenceSecondName,
			String insurenceLastName, String insurenceEGN,
			String insurenceCountry, String insurenceAddress,
			String insurencePK, String insurenceMobilePhone,
			String vehicleRegNumber, String vehicleType, String vehicleRama,
			String vehicleBranch, String vehicleModel,
			String insurenceDateFrom, String insurenceDateTo,
			int insurenceMonths, float insurenceValue, float insurencePremiq) {
		super();
		this.insurerID = insurerID;
		this.insurenceKaskoID = insurenceKaskoID;
		this.insurenceType = insurenceType;
		this.insurenceFirstName = insurenceFirstName;
		this.insurenceSecondName = insurenceSecondName;
		this.insurenceLastName = insurenceLastName;
		this.insurenceEGN = insurenceEGN;
		this.insurenceCountry = insurenceCountry;
		this.insurenceAddress = insurenceAddress;
		this.insurencePK = insurencePK;
		this.insurenceMobilePhone = insurenceMobilePhone;
		this.vehicleRegNumber = vehicleRegNumber;
		this.vehicleType = vehicleType;
		this.vehicleRama = vehicleRama;
		this.vehicleBranch = vehicleBranch;
		this.vehicleModel = vehicleModel;
		this.insurenceDateFrom = insurenceDateFrom;
		this.insurenceDateTo = insurenceDateTo;
		this.insurenceMonths = insurenceMonths;
		this.insurenceValue = insurenceValue;
		this.insurencePremiq = insurencePremiq;
	}

	public String getInsurerID() {
		return insurerID;
	}

	public void setInsurerID(String insurerID) {
		this.insurerID = insurerID;
	}

	public String getInsurenceKaskoID() {
		return insurenceKaskoID;
	}

	public void setInsurenceKaskoID(String insurenceKaskoID) {
		this.insurenceKaskoID = insurenceKaskoID;
	}

	public String getInsurenceType() {
		return insurenceType;
	}

	public void setInsurenceType(String insurenceType) {
		this.insurenceType = insurenceType;
	}

	public String getInsurenceFirstName() {
		return insurenceFirstName;
	}

	public void setInsurenceFirstName(String insurenceFirstName) {
		this.insurenceFirstName = insurenceFirstName;
	}

	public String getInsurenceSecondName() {
		return insurenceSecondName;
	}

	public void setInsurenceSecondName(String insurenceSecondName) {
		this.insurenceSecondName = insurenceSecondName;
	}

	public String getInsurenceLastName() {
		return insurenceLastName;
	}

	public void setInsurenceLastName(String insurenceLastName) {
		this.insurenceLastName = insurenceLastName;
	}

	public String getInsurenceEGN() {
		return insurenceEGN;
	}

	public void setInsurenceEGN(String insurenceEGN) {
		this.insurenceEGN = insurenceEGN;
	}

	public String getInsurenceCountry() {
		return insurenceCountry;
	}

	public void setInsurenceCountry(String insurenceCountry) {
		this.insurenceCountry = insurenceCountry;
	}

	public String getInsurenceAddress() {
		return insurenceAddress;
	}

	public void setInsurenceAddress(String insurenceAddress) {
		this.insurenceAddress = insurenceAddress;
	}

	public String getInsurencePK() {
		return insurencePK;
	}

	public void setInsurencePK(String insurencePK) {
		this.insurencePK = insurencePK;
	}

	public String getInsurenceMobilePhone() {
		return insurenceMobilePhone;
	}

	public void setInsurenceMobilePhone(String insurenceMobilePhone) {
		this.insurenceMobilePhone = insurenceMobilePhone;
	}

	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}

	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleRama() {
		return vehicleRama;
	}

	public void setVehicleRama(String vehicleRama) {
		this.vehicleRama = vehicleRama;
	}

	public String getVehicleBranch() {
		return vehicleBranch;
	}

	public void setVehicleBranch(String vehicleBranch) {
		this.vehicleBranch = vehicleBranch;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getInsurenceDateFrom() {
		return insurenceDateFrom;
	}

	public void setInsurenceDateFrom(String insurenceDateFrom) {
		this.insurenceDateFrom = insurenceDateFrom;
	}

	public String getInsurenceDateTo() {
		return insurenceDateTo;
	}

	public void setInsurenceDateTo(String insurenceDateTo) {
		this.insurenceDateTo = insurenceDateTo;
	}

	public int getInsurenceMonths() {
		return insurenceMonths;
	}

	public void setInsurenceMonths(int insurenceMonths) {
		this.insurenceMonths = insurenceMonths;
	}

	public float getInsurenceValue() {
		return insurenceValue;
	}

	public void setInsurenceValue(float insurenceValue) {
		this.insurenceValue = insurenceValue;
	}

	public float getInsurencePremiq() {
		return insurencePremiq;
	}

	public void setInsurencePremiq(float insurencePremiq) {
		this.insurencePremiq = insurencePremiq;
	}
}