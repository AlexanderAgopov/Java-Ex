package collections1;

import java.util.*;

public class CollectionsEx1 {

	private static String[] str = { "SAS", "BSBS", "FUFU", "SPEED", "OORRR" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<ArrayList<Integer>> subsetsQueue = new LinkedList<ArrayList<Integer>>();
		ArrayList<Integer> emptySet = new ArrayList<Integer>();
		subsetsQueue.offer(emptySet);
		while (!subsetsQueue.isEmpty()) {
			ArrayList<Integer> subset = subsetsQueue.poll();
			print(subset);
			System.out.println();
			int start = -1;
			if (subset.size() > 0) {
				start = subset.get(subset.size() - 1);
			}
			for (int index = start + 1; index < str.length; index++) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(index);
				subsetsQueue.offer(newSubset);
			}
		}

	}

	private static void print(ArrayList<Integer> subset) {
		for (int i = 0; i < subset.size(); i++) {
			int index = subset.get(i);
			System.out.print(str[index] + " ");

			
		}
	}

}
