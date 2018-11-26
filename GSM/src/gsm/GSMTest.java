package gsm;
import java.util.*;
public class GSMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GSM phone1 = new GSM();
		GSM phone2 = new GSM ("Nokia", "1000N", 452, 5.5, new Battery());
		
		Battery battery1 = new Battery("Varta", 48, 10.5);
		Battery battery2 = new Battery("Panasonic", 36, 8);
		
		GSM phone3 = new GSM("Samsung", "S11", 1995, 6.2, battery1);
		GSM phone4 = new GSM("Aplle", "iPhone 16", 2420, 6.5, battery2);
		
		GSM[] phones = {phone1, phone2, phone3, phone4};
		
		for(GSM phone: phones) {
			phone.printPhoneFullInfo();
			
			//phone.printBatInformation();
		}
		System.out.println();
		GSM.printHuawei();
		System.out.println();
		ArrayList gsmList = new ArrayList();
		gsmList.add(phone1);
		gsmList.add(phone2);
		gsmList.add(phone3);
		gsmList.add(phone4);
		System.out.println(gsmList.size());
		System.out.println(gsmList);

	}

}
