package hash;

import java.util.HashSet;

public class HashSetExample {
	
	public static void main(String[] args) {
		
		HashSet<String> stringSet = new HashSet();
		
		String a = "a";
		String a1 = "a";
		String b = "b";
		
		stringSet.add(a);
		stringSet.add(a1);
		stringSet.add(b);
		
		System.out.println(stringSet.toString());
	}

}
