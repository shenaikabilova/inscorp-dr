/**
 * 
 */
package model;

/**
 * @author shenaikabilova
 *
 */
public class VehicleBrand {
	private String vehicleBrand;
	
	public VehicleBrand () {
		
	}
	
	public VehicleBrand (String typeVehicle) {
		this.vehicleBrand = typeVehicle;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
}