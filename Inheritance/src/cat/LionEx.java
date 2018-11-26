package cat;

public class LionEx {

	public static void main(String[] args) {
		AfricanLion kumba = new AfricanLion(true, 100);

		System.out.println(kumba.toString());
		
		Lion lion = new Lion(false, 200);
		Lion lion2 = new AfricanLion(true, 150);
		
		lion.catchPray(null);
		
		kumba.catchPray(null);
		
		lion2.catchPray(null);
	}

}
