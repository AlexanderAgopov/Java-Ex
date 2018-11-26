package set.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains 2 methods. The first method called "union" returns a new
 * set which unites 2 existing sets of objects of certain type. The second class
 * called "intersect" returns new set which contains only objects that are
 * elements of both of the predefined sets.
 * 
 * @author a
 *
 * @param <E>
 */
public class HashSet1<E> {
	/**
	 * 
	 * @param set1 - set of objects of certain type
	 * @param set2 - set of objects of certain type
	 * @return new set which unites 2 existing sets of objects of certain type
	 */
	public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
		Set<E> union = new HashSet<E>();
		union.addAll(set1);
		union.addAll(set2);
		return union;
	}

	/**
	 * 
	 * @param set1 - set of objects of certain type
	 * @param set2 - set of objects of certain type
	 * @return new set which contains only objects that are elements of both set1
	 *         and set2
	 */
	public static <E> Set<E> intersect(Set<E> set1, Set<E> set2) {
		Set<E> intersect = new HashSet<E>();
		intersect.addAll(set1);
		intersect.retainAll(set2);
		return intersect;
	}

	public static void main(String[] args) {
		Set<String> names1 = new HashSet<String>();
		Set<String> names2 = new HashSet<String>();
		names1.add("A");
		names1.add("B");
		names1.add("C");
		names2.add("C");
		names2.add("X");
		names2.add("Z");

		System.out.println(union(names1, names2));
		System.out.println(intersect(names1, names2));

	}

}
