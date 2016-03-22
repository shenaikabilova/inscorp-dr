/**
 * 
 */
package model;

/**
 * @author shenaikabilova
 *
 */
public class VehicleType {
	private String vehicleType;
	
	public VehicleType () {
		
	}
	
	public VehicleType (String typeVehicle) {
		this.vehicleType = typeVehicle;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String typeVehicle) {
		this.vehicleType = typeVehicle;
	}
}