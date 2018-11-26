package ex;

import java.util.Scanner;

public class Ex {

	private static String s = "* *";
	private static int size = 0;
	private static StringBuilder sb = new StringBuilder(s);

	private static void doTriangle() {
		
		if(size == 1) {
			System.out.println(s);
		} else {
			s = sb.toString();
			System.out.println(sb.toString());
			sb.setCharAt(sb.indexOf(" "), '*');
			sb.setCharAt(sb.lastIndexOf(" "), '*');
			if (s.indexOf(" ") + 1 == s.lastIndexOf(" ")) {
				sb.replace(sb.length() / 2, sb.length() / 2 + 1, "*");
				System.out.println(sb.toString());
			} else {
				doTriangle();
			}
		}	
	}

	private static void createInitialString() {
		
		 if (size == 1) {
			 
		 } else {
			 sb.insert(1, " ");
				s = sb.toString();
			 if (s.length() == size * 2 - 1) {
					sb = sb.insert(1, " ");
					s = sb.toString();
				} else {
					createInitialString();
				} 
		 }
		
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the size of the triangle:");
		size = input.nextInt();

		createInitialString();
		doTriangle();

	}
}