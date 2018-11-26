package tree.treeset;
import java.util.TreeSet;
public class TreeSetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> treeInt = new TreeSet<Integer>();
		treeInt.add(8);
		treeInt.add(12);
		treeInt.add(9);
		treeInt.add(123);
		treeInt.add(55);
		treeInt.remove(123);
		
		for(int i : treeInt) {
			System.out.println(i);
		}

	}

}
