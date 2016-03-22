import model.Insurer;
import model.VehicleColor;
import model.VehicleType;
import dao_api.InsurerDAO;
import dao_api.VehicleColorDAO;
import dao_api.VehicleTypeDAO;
import dao_jdbc.InsurerDAOImpl;
import dao_jdbc.VehicleColorDAOImpl;
import dao_jdbc.VehicleTypeDAOImpl;

public class Example {
	public static void main(String[] args) {
//		InsurerDAO ins = new InsurerDAOImpl();
//		Insurer insurer1 = new Insurer("000001", "Shenai", "Kabilova", "1234567");
//		Insurer insurer2 = new Insurer("000002", "Ivan", "Ivanov", "123456", "user");
//		
//		///System.out.println(ins.searchUserName("000000").getInsurerId() + " " + ins.searchUserName("000000").getInsurerPassword());
//		System.out.println(new InsurerDAOImpl().searchUserName("000000").getInsurerId().equals("000000"));
//		
//		VehicleTypeDAO v = new VehicleTypeDAOImpl();
//		for (VehicleType vt : v.listAllVehicleTypes()) {
//			System.out.println(vt.getVehicleType());
//		}
		
		VehicleColorDAO colors = new VehicleColorDAOImpl();
		for(VehicleColor color : colors.listAllVehicleColors()) {
			System.out.println(color.getVehicleColor());
		}
	}
}