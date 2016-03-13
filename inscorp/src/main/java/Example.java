import model.Insurer;
import dao.InsurerDAO;
import dao.InsurerDAOImpl;

public class Example {
	public static void main(String[] args) {
		InsurerDAO ins = new InsurerDAOImpl();
		Insurer insurer1 = new Insurer("000001", "Shenai", "Kabilova", "1234567");
		Insurer insurer2 = new Insurer("000002", "Ivan", "Ivanov", "123456", "user");
		
		///System.out.println(ins.searchUserName("000000").getInsurerId() + " " + ins.searchUserName("000000").getInsurerPassword());
		System.out.println(new InsurerDAOImpl().searchUserName("000000").getInsurerId().equals("000000"));
	}
}