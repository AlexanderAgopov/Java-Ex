package list.arraylistsintersect;
import java.util.ArrayList;
public class ArrayListsUnion {
	
	public static ArrayList<Integer> union(ArrayList<Integer> firstList, ArrayList<Integer> secondList){
		ArrayList<Integer> union = new ArrayList<Integer>();
		for(Integer i: firstList) {
			union.add(i);
		}
		
		for(Integer item : secondList) {
			if(!union.contains(item)) {
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
		
		ArrayList<Integer> union = union(firstList, secondList);
		for(int i = 0; i < union.size(); i++) {
			System.out.print(union.get(i) + " ");
		}
		
		System.out.println();
		//Another easier way but it is buggy
		ArrayList<Integer> unionAlt = union(firstList, secondList);
		unionAlt.addAll(firstList);
		unionAlt.removeAll(secondList);
		unionAlt.addAll(secondList);
		for(Integer item: unionAlt) {
			System.out.print(item + " ");
		}

	}

}
