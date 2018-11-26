package map.ex;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * 
 * @author a
 *
 */
public class EvenNumberOfOccurrences {
	/**
	 * THis method checks which are the integer numbers that occur in an array list of
	 * integers even number of times, deletes the other integer numbers from the list and
	 * prints the result.
	 * 
	 * @param list
	 */
	private static void printEvenOccurrences(ArrayList<Integer> list) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		System.out.println("The original collection: " + list);
		for (int i = 0; i < list.size(); i++) {
			if (map.containsKey(list.get(i))) {
				int temp = (int) (map.get(list.get(i)) + 1);
				map.put(list.get(i), temp);
			} else {
				map.put(list.get(i), 1);
			}
		}
		ArrayList<Integer> evenNumberOfOccurrences = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				evenNumberOfOccurrences.add(entry.getKey());
			}
		}

		System.out.println(
				"The numbers that should stay in the collection, i.e. the numbers that occur even number of times: "
						+ evenNumberOfOccurrences);
		list.retainAll(evenNumberOfOccurrences);
		System.out.println("The result: " + list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 2, 2, 5, 2, 3, 2, 3, 1, 5, 2, 6, 6, 6 };

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		printEvenOccurrences(list);

	}

}
