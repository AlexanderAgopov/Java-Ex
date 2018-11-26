package list.ArrayList;
import java.util.ArrayList;
public class ArrayListIntegerElementsSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(3);
		list.add(6);
		int sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Integer value = list.get(i);
			sum = sum + value.intValue();
		}
		
		System.out.println("The sum is : " + sum);

	}

}
