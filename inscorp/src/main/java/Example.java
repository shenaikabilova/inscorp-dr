import model.Insurer;
import model.Kasko;
import model.VehicleColor;
import model.VehicleBrand;
import dao_api.InsurerDAO;
import dao_api.KaskoDAO;
import dao_api.VehicleColorDAO;
import dao_api.VehicleBrandDAO;
import dao_jdbc.InsurerDAOImpl;
import dao_jdbc.KaskoDAOImpl;
import dao_jdbc.VehicleColorDAOImpl;
import dao_jdbc.VehicleBrandDAOImpl;

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
//		
//		VehicleColorDAO colors = new VehicleColorDAOImpl();
//		for(VehicleColor color : colors.listAllVehicleColors()) {
//			System.out.println(color.getVehicleColor());
//		}
//		
//		InsurerDAO insurer = new InsurerDAOImpl();
//		insurer.insert(new Insurer("8", "����", "������", "aaa", "123"));
		
//		KaskoDAO searchByID = new KaskoDAOImpl();
//		System.out.println(searchByID.searchKasko("000001").getInsKaskoId());
		
//		KaskoDAO searchAll = new KaskoDAOImpl();
//		for(Kasko all : searchAll.searchKaskoByInsurer("000001")) {
//			System.out.println(all.getInsKaskoId());
//		}
		
//		System.out.println(new InsurerDAOImpl().searchUserName("000000").getInsurerId().equals("000000"));
//		if(new InsurerDAOImpl().searchUserName("000000").getInsurerId().equals("000000") &&
//				   new InsurerDAOImpl().searchUserName("000000").getInsurerPassword().equals("aaa")) {
//			System.out.println("true");
//		}
//		else System.out.println("false");
		
		System.out.println(new InsurerDAOImpl().isUser("000000", "admin"));
	}
}