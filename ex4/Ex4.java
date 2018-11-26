package ex4;

import java.util.Scanner;

public class Ex4 {

	private static String s = "* *";
	private static int size = 0;
	private static StringBuilder sb = new StringBuilder(s);

	private static void doTriangle() {

	    if (size <= 2) {
	        if (size == 1) {
	            System.out.println(s);
	        } else {
	            System.out.println(s);
	            sb.setCharAt(sb.indexOf(" "), '*');
	            sb.delete(sb.length() / 2, sb.length() / 2);
	            s = sb.toString();
	            System.out.println(sb.toString());
	        }
	    } else {
	        s = sb.toString();
	        System.out.println(sb.toString());
	        sb.setCharAt(sb.indexOf(" "), '*');
	        sb.setCharAt(sb.lastIndexOf(" "), '*');
	        sb.delete(sb.length() / 2, sb.length() / 2);

	        if (s.indexOf(" ") + 2 == s.lastIndexOf(" ")) {
	            sb.setCharAt(sb.indexOf(" "), '*');
	            sb.setCharAt(sb.length() / 2, ' ');
	            System.out.println(sb.toString());
	            sb.setCharAt(sb.length() / 2, '*');
	            System.out.println(sb.toString());
	        } else {
	            doTriangle();
	        }
	    }

	}

	private static void createInitialString() {

	    if (size <= 2) {

	    } else {
	        sb.insert(1, " ");
	        s = sb.toString();
	        if (s.length() == size * 2 - 2) {
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
