package collections2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Даден е текстов файл, съдържащ данните за група студенти и курсовете, които
 * те изучават /име, фамилия, курс/.Да се напише програма, която отпечатва
 * всички курсове и за всеки от тях студентите, които са ги записали, подредени
 * първо по фамилия, след това по име (ако фамилиите съвпадат).
 * 
 * @author Nakov i co.
 *
 */
public class ITSChoolBookImplementation {

	public static void main(String[] args) throws FileNotFoundException {
		// Read the file and build the hash-table of courses
		HashMap<String, ArrayList<Student>> courses = new HashMap<String, ArrayList<Student>>();
		Scanner input = new Scanner(new File("studentsAndCourses"));
		try {
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] studentEntry = line.split(" ");
				String firstName = studentEntry[0];
				String lastName = studentEntry[1];
				String course = studentEntry[2];
				ArrayList<Student> students = courses.get(course);
				if (students == null) {
					// New course -> create a list of students for it
					students = new ArrayList<Student>();
					courses.put(course, students);
				}
				Student student = new Student(firstName, lastName, "0"); // I added the "0" course as an argument to the
																			// constructor because I had to adapt the
																			// book's example to the overridden method
																			// "compareTo"
				students.add(student);
			}
		} finally {
			input.close();
		}
		// Print the courses and their students
		Set<String> coursesNames = courses.keySet();
		for (String course : coursesNames) {
			System.out.println("Course " + course + ":");
			ArrayList<Student> students = courses.get(course);
			Student[] studentsArr = students.toArray(new Student[students.size()]);
			Arrays.sort(studentsArr); // My personal optimization is to use Collections.sort(nameOfArrayList) instead
										// of the book's approach namely to create new array and sort it.
			for (Student student : studentsArr) {
				System.out.printf("\t%s\n", student);
			}

		}
	}

}
