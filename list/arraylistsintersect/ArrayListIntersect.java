package list.arraylistsintersect;

import java.util.ArrayList;

public class ArrayListIntersect {

	ArrayList<Integer> firstList;
	ArrayList<Integer> secondList;

	public ArrayListIntersect(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
		this.firstList = firstList;
		this.secondList = secondList;
	}

	// This is my method which returns array list containing the numbers that are
	// contained at the same time in both lists (firstList and secondList)
	private ArrayList<Integer> intersectList() {
		ArrayList<Integer> intersectList = new ArrayList<Integer>();
		for (Integer int1 : this.firstList) {
			for (Integer int2 : this.secondList) {
				if (int1.equals(int2)) {
					intersectList.add(int1);
				}
			}
		}
		return intersectList;
	}

	// This is the method in the textbook. Probably it is better than mine because
	// it uses if expression instead of nested loop (but since contains() uses
	// foreach loop it is the same)???
	public ArrayList<Integer> union() {
		ArrayList<Integer> union = new ArrayList<Integer>();
		union.addAll(this.firstList);
		for (Integer item : this.secondList) {
			if (!union.contains(item)) {
				union.add(item);
			}
		}
		return union;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		ArrayList<Integer> secondList = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			firstList.add(i);
		}
		for (int i = 6; i < 16; i++) {
			secondList.add(i);
		}

		ArrayListIntersect interList = new ArrayListIntersect(firstList, secondList);
		ArrayList<Integer> inter = interList.intersectList();
		for (int i = 0; i < inter.size(); i++) {
			System.out.println(inter.get(i));
		}
		System.out.println();
		
		//The easiest way
		ArrayList<Integer> intersectEZ = new ArrayList<Integer>();
		intersectEZ.addAll(firstList);
		intersectEZ.retainAll(secondList);
		for(Integer item : intersectEZ) {
			System.out.print(item + " ");
		}

	}

}
