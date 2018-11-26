package set.ex;

import java.util.Set;
import java.util.HashSet;

/**
 * Дадени са три редици от числа, дефинирани чрез формулите: - f 1 (0) = 1; f 1
 * (k) = 2*f 1 (k-1) + 3; f 1 = {1, 5, 13, 29, ...} - f 2 (0) = 2; f 2 (k) = 3*f
 * 2 (k-1) + 1; f 2 = {2, 7, 22, 67, ...} - f 3 (0) = 2; f 3 (k) = 2*f 3 (k-1) -
 * 1; f 3 = {2, 3, 5, 9, ...} Напишете програма, която намира сечението и
 * обединението на множе- ствата от членовете на редиците в интервала [0;
 * 100000]: f 1 * f 2 ; f 1 * f 3 ; f 2* f 3 ; f 1 * f 2 * f 3 ; f 1 + f 2 ; f 1
 * + f 3 ; f 2 + f 3 ; f 1 + f 2 + f 3 . Със символите + и * означаваме
 * съответно обединение и сечение на множества.
 * 
 * @author a
 *
 */
public class MathF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		Set<Integer> set3 = new HashSet<Integer>();
		
		set1.add(0);
		set2.add(0);
		set3.add(0);

		int s1 = 1;
		int s2 = 2;
		int s3 = 2;

		while (true) {
			s1 = 2 * s1 + 3;
			set1.add(s1);
			if (s1 > 100000) {
				break;
			}
		}

		while (true) {
			s2 = 3 * s2 + 1;
			set2.add(s2);
			if (s2 > 100000) {
				break;
			}
		}

		while (true) {
			s3 = 2 * s3 - 1;
			set3.add(s3);
			if (s3 > 100000) {
				break;
			}
		}

		System.out.println(set1.toString());
		System.out.println(set2.toString());
		System.out.println(set3.toString());
		
		Set<Integer> set1and2 = new HashSet<Integer>();
		
		set1and2.addAll(set1);
		set1and2.addAll(set2);
		System.out.println("f1 + f2 : " + set1and2.toString());
		
		Set<Integer> set1or2 = new HashSet<Integer>();
		set1or2.addAll(set1);
		set1or2.retainAll(set2);
		System.out.println("f1 * f2 : " + set1or2.toString());
		
		Set<Integer> set1or3 = new HashSet<Integer>();
		set1or3.addAll(set1);
		set1or3.retainAll(set3);
		System.out.println("f1 * f3 : " + set1or3.toString());

	}

}
