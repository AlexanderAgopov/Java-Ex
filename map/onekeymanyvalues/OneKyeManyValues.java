package map.onekeymanyvalues;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * HashMap - Single Key and Multiple Values using ArrayList
 * 
 * @author a
 *
 */
public class OneKyeManyValues {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("AAA");
		list1.add("BBB");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("CCC");
		list2.add("AAA");
		
		map.put(1, list1);
		map.put(2, list2);
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		

	}

}
