import dao.InsurerDAO;
import dao.InsurerDAOImps;

public class Example {
	public static void main(String[] args) {
		InsurerDAO ins = new InsurerDAOImps();
		System.out.println(ins.searchUserName("Admin").getInsurerId());
		System.out.println(ins.searchUserName("Admin").getInsurerName());
		System.out.println(ins.searchUserName("Admin").getInsurerFamily());
		System.out.println(ins.searchUserName("Admin").getInsurerPassword());
		System.out.println(ins.searchUserName("Admin").getRole());
	}
}