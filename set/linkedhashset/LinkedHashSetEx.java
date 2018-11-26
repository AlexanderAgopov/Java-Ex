package set.linkedhashset;
import java.util.LinkedHashSet;
public class LinkedHashSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		lhs.add("FFF");
		lhs.add("AAA");
		lhs.add("FFF");
		lhs.add("SSS");
		lhs.add("AAA");
		
		System.out.println(lhs);

	}

}
