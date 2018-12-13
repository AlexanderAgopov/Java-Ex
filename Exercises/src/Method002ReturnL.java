
public class Method002ReturnL {
	
	public static double division1(double x, int y) {
		
				
		double z = x / y;
		
		return z;
	}
	
	public static double division2(double x, int y) {
		
		return x / y;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(division1(556, 11));
		System.out.println();
		System.out.println(division2(556, 11));
		
		double a = division1(556, 11) - division2(556, 11);
		System.out.println(a);
		System.out.println(division1(556, 11) - division2(556, 11));
		

	}

}
