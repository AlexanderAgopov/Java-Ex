package set.treeset;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;
import java.util.Set;

public class TreeSet1 {
	/**
	 * This class uses tree set in order to remove the repetitions of each of the
	 * elements in an array and to sort them in an ascending order.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();

		char[] arr = new char[300];
		for (int i = 0; i < arr.length; i++) {
			int a = r.nextInt(36);
			char c = (char) (a + 'A');
			arr[i] = c;
		}

		System.out.println(Arrays.toString(arr));
		//The class works fine with both Set<E> and SortedSet<E> 
		Set<Character> set = new TreeSet<Character>();
		for(char ch: arr) {
			set.add(ch);
		}
		System.out.println(set);

	}

}
