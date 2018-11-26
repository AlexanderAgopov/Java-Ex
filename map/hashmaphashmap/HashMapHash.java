package map.hashmaphashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * The purpose of this class is to create a pair of keys for each value stored
 * in an abstract data structure. In order to achieve this we create hash map of
 * hash maps.
 * 
 * @author a
 *
 */
public class HashMapHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, HashMap<Integer, String>> mapOfMaps = new HashMap<Integer, HashMap<Integer, String>>();

		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");

		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(11, "AA");
		map2.put(22, "BB");
		map2.put(33, "CC");

		mapOfMaps.put(100, (HashMap<Integer, String>) map1);
		mapOfMaps.put(200, (HashMap<Integer, String>) map2);

		System.out.println(mapOfMaps.get(100).get(2));
		System.out.println(mapOfMaps.get(200).get(33));

	}

}
