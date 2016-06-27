import java.util.Date;
import java.util.Scanner;

import Exceptions.InsCorpErrorException;
import model.GrajdanskaOtgovornost;
import model.Insurer;
import model.Kasko;
import model.VehicleColor;
import model.VehicleBrand;
import dao_api.GrajdanskaOtgovornostDAO;
import dao_api.InsurerDAO;
import dao_api.KaskoDAO;
import dao_api.VehicleColorDAO;
import dao_api.VehicleBrandDAO;
import dao_jdbc.GrajdanskaOtgovornostDAOImpl;
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
//		try {
//			if(!(insurer.searchUserName("0000010").getInsurerId() == null)) {
//				System.out.println("yes");
//			}
//		} catch (InsCorpErrorException e) {
//			System.out.println(e.getMessage());
//		}
//		insurer.insert(new Insurer("8", "����", "������", "aaa", "123"));
//		Insurer ins = new Insurer("000004", "�����", "����������", "aaaaaa@aa.bg", "aaa");
//		try {
//			insurer.update(ins);
//		} catch (InsCorpErrorException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			System.out.println(insurer.searchUserName("000004").getInsurerId());
//			System.out.println(insurer.searchUserName("000004").getInsurerEmail());
//		} catch (InsCorpErrorException e) {
//			System.out.println(e.getMessage());
//		}
	
//		KaskoDAO searchByID = new KaskoDAOImpl();
//		System.out.println(searchByID.searchKasko("000006").getInsKaskoId());
		
//		KaskoDAO searchAll = new KaskoDAOImpl();
//		for(Kasko all : searchAll.searchKaskoByInsurer("000001")) {
//			System.out.println(all.getInsKaskoId());
//		}
//		System.out.println(searchAll.searchKasko("000001").getInsKaskoId());
//		System.out.println(new InsurerDAOImpl().searchUserName("000000").getInsurerId().equals("000000"));
//		if(new InsurerDAOImpl().searchUserName("000000").getInsurerId().equals("000000") &&
//				   new InsurerDAOImpl().searchUserName("000000").getInsurerPassword().equals("aaa")) {
//			System.out.println("true");
//		}
//		else System.out.println("false");
//		
//		System.out.println(new InsurerDAOImpl().isUser("000000", "admin"));
//		
//		@SuppressWarnings("deprecation")
//		Kasko kasko = new Kasko("000001", "100014", "��������� ����", "������", "������", "������", 
//				"8807070011", "123456", "��. �����", 9000, "�4589��", "���������", "�14789�RD78954123", 
//				"����", "�5", "���", 2005, new Date(2005-1900, 10-1, 10), 2.0f, 4, 10000, 500);
//		KaskoDAO dao = new KaskoDAOImpl();
////		dao.insertKasko(kasko);
//		System.out.println(dao.searchKasko("100014").getInsurerId());
//		System.out.println(dao.searchKasko("100014").getInsKaskoId());
//		System.out.println(dao.searchKasko("100014").getInsurenceFirstName());
//		
//		@SuppressWarnings("deprecation")
//		GrajdanskaOtgovornost go = new GrajdanskaOtgovornost("000001", "000002", "��������� ����", 
//				"����", "������", "������", "8602020511", "��������", "��. �����", 9000, "111222", "�8887�", 
//				"���� I� - �������, ����� � ������", "���������", "BG478965��78952BA", "����", "�5", 
//				new Date(2016-1900, 7-1, 20), new Date(2017-1900, 7-1, 19), 12, 150, 150);
//		GrajdanskaOtgovornostDAO dao = new GrajdanskaOtgovornostDAOImpl();
//		System.out.println(dao.searchGO("11").getInsurenceGrajdanskaOtgovornostID());
////		
//////		dao.insertGO(go);
////		
//		for(GrajdanskaOtgovornost g : dao.listGO()) {
//			System.out.println(g.getInsurenceGrajdanskaOtgovornostID());
//		}

		Scanner input = new Scanner(System.in);
        String S;
        S = input.nextLine();
        
        for(int i=0; i<S.length(); i++) {
            if(i % 2 == 0) {
                System.out.print(S.charAt(i));
            }
        }
        System.out.print(" ");
        for(int i=0; i<S.length(); i++) {
            if(i % 2 != 0) {
                System.out.print(S.charAt(i));
            }
        }
        input.close();
	}
}