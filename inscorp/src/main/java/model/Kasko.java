package model;

import java.util.Date;

/**
 * The Kasko class represent kasko objects.
 * @author shenaikabilova
 */
public class Kasko {
	private String insurerId;
	private String insKaskoId;
	private String insType;
	private String insurenceFirstName;
	private String insurenceSecondName;
	private String insurenceFamily;
	private String insurenceEGN;
	private String insurenceMobilePhone;
	private String insurenceAddress;
	private int insurencePK;
	private String vehicleRegistrationNumber;
	private String vehicleType;
	private String vehicleRama;
	private String vehicleBrand;
	private String vehicleModel;
	private String vehicleColor;
	private int vehicleYear;
	private Date vehicleFirstRegistration;
	private float vehicleEngine;
	private int vehiclePlaceNumber;
	private float vehicleInsurenceValue;
	private float vehicleInsurencePremiq;
	
	public Kasko() {
	}
	
	public Kasko(String insKaskoId, String insType, String insurenceFirstName, String insurenceSecondName, String insurenceFamily, 
			String insurenceEGN, String insurenceMobilePhone, String insurenceAddress, int insurencePK, 
			String vehicleRegistrationNumber, String vehicleType, String vehicleRama, String vehicleBrand, 
			String vehicleModel, String vehicleColor, int vehicleYear, Date vehicleFirstRegistration, float vehicleEngine, 
			int vehiclePlaceNumber, float vehicleInsurenceValue, float vehicleInsurencePremiq) {
		this.insKaskoId = insKaskoId;
		this.insType = insType;
		this.insurenceFirstName = insurenceFirstName;
		this.insurenceSecondName = insurenceSecondName;
		this.insurenceFamily = insurenceFamily;
		this.insurenceEGN = insurenceEGN;
		this.insurenceMobilePhone = insurenceMobilePhone;
		this.insurenceAddress = insurenceAddress;
		this.insurencePK = insurencePK;
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
		this.vehicleType = vehicleType;
		this.vehicleRama = vehicleRama;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.vehicleColor = vehicleColor;
		this.vehicleYear = vehicleYear;
		this.vehicleFirstRegistration = vehicleFirstRegistration;
		this.vehicleEngine = vehicleEngine;
		this.vehiclePlaceNumber = vehiclePlaceNumber;
		this.vehicleInsurenceValue = vehicleInsurenceValue;
		this.vehicleInsurencePremiq = vehicleInsurencePremiq;
	}

	public Kasko(String insurerId, String insKaskoId, String insType, String insurenceFirstName, String insurenceSecondName, String insurenceFamily, 
			String insurenceEGN, String insurenceMobilePhone, String insurenceAddress, int insurencePK, 
			String vehicleRegistrationNumber, String vehicleType, String vehicleRama, String vehicleBrand, 
			String vehicleModel, String vehicleColor, int vehicleYear, Date vehicleFirstRegistration, float vehicleEngine, 
			int vehiclePlaceNumber, float vehicleInsurenceValue, float vehicleInsurencePremiq) {
		this.insurerId = insurerId;
		this.insKaskoId = insKaskoId;
		this.insType = insType;
		this.insurenceFirstName = insurenceFirstName;
		this.insurenceSecondName = insurenceSecondName;
		this.insurenceFamily = insurenceFamily;
		this.insurenceEGN = insurenceEGN;
		this.insurenceMobilePhone = insurenceMobilePhone;
		this.insurenceAddress = insurenceAddress;
		this.insurencePK = insurencePK;
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
		this.vehicleType = vehicleType;
		this.vehicleRama = vehicleRama;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.vehicleColor = vehicleColor;
		this.vehicleYear = vehicleYear;
		this.vehicleFirstRegistration = vehicleFirstRegistration;
		this.vehicleEngine = vehicleEngine;
		this.vehiclePlaceNumber = vehiclePlaceNumber;
		this.vehicleInsurenceValue = vehicleInsurenceValue;
		this.vehicleInsurencePremiq = vehicleInsurencePremiq;
	}
	
	public String getInsurerId() {
		return insurerId;
	}

	public void setInsurerId(String insurerId) {
		this.insurerId = insurerId;
	}

	public String getInsKaskoId() {
		return insKaskoId;
	}

	public void setInsType(String insType) {
		this.insType = insType;
	}
	
	public String getInsType() {
		return insType;
	}
	
	public void setInsKaskoId(String insKaskoId) {
		this.insKaskoId = insKaskoId;
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

	public String getInsurenceFamily() {
		return insurenceFamily;
	}

	public void setInsurenceFamily(String insurenceFamily) {
		this.insurenceFamily = insurenceFamily;
	}

	public String getInsurenceEGN() {
		return insurenceEGN;
	}

	public void setInsurenceEGN(String insurenceEGN) {
		this.insurenceEGN = insurenceEGN;
	}

	public String getInsurenceMobilePhone() {
		return insurenceMobilePhone;
	}

	public void setInsurenceMobilePhone(String insurenceMobilePhone) {
		this.insurenceMobilePhone = insurenceMobilePhone;
	}

	public String getInsurenceAddress() {
		return insurenceAddress;
	}

	public void setInsurenceAddress(String insurenceAddress) {
		this.insurenceAddress = insurenceAddress;
	}

	public int getInsurencePK() {
		return insurencePK;
	}

	public void setInsurencePK(int insurencePK) {
		this.insurencePK = insurencePK;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
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

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public int getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(int vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public Date getVehicleFirstRegistration() {
		return vehicleFirstRegistration;
	}

	public void setVehicleFirstRegistration(Date vehicleFirstRegistration) {
		this.vehicleFirstRegistration = vehicleFirstRegistration;
	}

	public float getVehicleEngine() {
		return vehicleEngine;
	}

	public void setVehicleEngine(float vehicleEngine) {
		this.vehicleEngine = vehicleEngine;
	}

	public int getVehiclePlaceNumber() {
		return vehiclePlaceNumber;
	}

	public void setVehiclePlaceNumber(int vehiclePlaceNumber) {
		this.vehiclePlaceNumber = vehiclePlaceNumber;
	}

	public float getVehicleInsurenceValue() {
		return vehicleInsurenceValue;
	}

	public void setVehicleInsurenceValue(float vehicleInsurenceValue) {
		this.vehicleInsurenceValue = vehicleInsurenceValue;
	}

	public float getVehicleInsurencePremiq() {
		return vehicleInsurencePremiq;
	}

	public void setVehicleInsurencePremiq(float vehicleInsurencePremiq) {
		this.vehicleInsurencePremiq = vehicleInsurencePremiq;
	}
}