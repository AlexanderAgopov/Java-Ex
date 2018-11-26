package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {

		String mydata = "oauthscope: command_path.use";
		String s = mydata.substring(mydata.lastIndexOf(" ") + 1);
		System.out.println(s);

	}
}
