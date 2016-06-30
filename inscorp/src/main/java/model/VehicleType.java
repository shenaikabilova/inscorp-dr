package model;

/**
 * The VehicleType class represents vehicle type objects.
 * @author shenaikabilova
 */
public class VehicleType {
	private String vehicleType;
	
	public VehicleType() {
		
	}

	public VehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
}