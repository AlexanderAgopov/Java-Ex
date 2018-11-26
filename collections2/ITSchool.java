package collections2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Даден е текстов файл, съдържащ данните за група студенти и курсовете, които
 * те изучават /име, фамилия, курс/.Да се напише програма, която отпечатва
 * всички курсове и за всеки от тях студентите, които са ги записали, подредени
 * първо по фамилия, след това по име (ако фамилиите съвпадат).
 * 
 * @author a
 *
 */
public class ITSchool {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("studentsAndCourses");
		Scanner sf = new Scanner(file);
		ArrayList<Student> list = new ArrayList<Student>();
		while (sf.hasNextLine()) {
			String[] line = sf.nextLine().split(" ");
			list.add(new Student(line[1], line[0], line[2])); // Switch the places of 1 and 0 if you want to print the
																// first name first.
		}
		Collections.sort(list);
		System.out.println(list.get(0).getCourse());
		System.out.println(list.get(0).getName());
		for (int i = 1; i < list.size(); i++) {
			if (!list.get(i).getCourse().equals(list.get(i - 1).getCourse())) {
				System.out.println(list.get(i).getCourse());
			}
			System.out.println(list.get(i).getName());
		}

		sf.close();

	}

}
